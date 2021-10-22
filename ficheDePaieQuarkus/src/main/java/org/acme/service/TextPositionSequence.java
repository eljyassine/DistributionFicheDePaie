package org.acme.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TextPositionSequence implements CharSequence
{
    public TextPositionSequence(List<TextPosition> textPositions)
    {
        this(textPositions, 0, textPositions.size());
    }

    public TextPositionSequence(List<TextPosition> textPositions, int start, int end)
    {
        this.textPositions = textPositions;
        this.start = start;
        this.end = end;
    }

    @Override
    public int length()
    {
        return end - start;
    }

    @Override
    public char charAt(int index)
    {
        TextPosition textPosition = textPositionAt(index);
        String text = textPosition.getUnicode();
        return text.charAt(0);
    }

    @Override
    public TextPositionSequence subSequence(int start, int end)
    {
        return new TextPositionSequence(textPositions, this.start + start, this.start + end);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder(length());
        for (int i = 0; i < length(); i++)
        {
            builder.append(charAt(i));
        }
        return builder.toString();
    }

    public TextPosition textPositionAt(int index)
    {
        return textPositions.get(start + index);
    }

    public float getX()
    {
        return textPositions.get(start).getXDirAdj();
    }

    public float getY()
    {
        return textPositions.get(start).getYDirAdj();
    }

    public float getWidth()
    {
        if (end == start)
            return 0;
        TextPosition first = textPositions.get(start);
        TextPosition last = textPositions.get(end - 1);
        return last.getWidthDirAdj() + last.getXDirAdj() - first.getXDirAdj();
    }

    final List<TextPosition> textPositions;
    final int start, end;

    static void printSubwords(PDDocument document, String searchTerm) throws IOException
    {
        System.out.printf("* Looking for '%s'\n", searchTerm);
        for (int page = 1; page <= document.getNumberOfPages(); page++)
        {
            List<TextPositionSequence> hits = findSubwords(document, page, searchTerm);
            for (TextPositionSequence hit : hits)
            {
                TextPosition lastPosition = hit.textPositionAt(hit.length() - 1);
                System.out.printf("  Page %s at %s, %s with width %s and last letter '%s' at %s, %s\n",
                        page, hit.getX(), hit.getY(), hit.getWidth(),
                        lastPosition.getUnicode(), lastPosition.getXDirAdj(), lastPosition.getYDirAdj());
            }
        }
    }



    static List<TextPositionSequence> findSubwords(PDDocument document, int page, String searchTerm) throws IOException
    {
        final List<TextPositionSequence> hits = new ArrayList<>();
        PDFTextStripper stripper = new PDFTextStripper()
        {
            @Override
            protected void writeString(String text, List<TextPosition> textPositions) throws IOException
            {
                TextPositionSequence word = new TextPositionSequence(textPositions);
                String string = word.toString();

                int fromIndex = 0;
                int index;
                while ((index = string.indexOf(searchTerm, fromIndex)) > -1)
                {
                    hits.add(word.subSequence(index, index + searchTerm.length()));
                    fromIndex = index + 1;
                }
                super.writeString(text, textPositions);
            }
        };

        stripper.setSortByPosition(true);
        stripper.setStartPage(page);
        stripper.setEndPage(page);
        stripper.getText(document);
        return hits;
    }

        public static void main(String[] args) throws IOException {


                try (//InputStream resource = TextPositionSequence.class.getResourceAsStream( );
                     PDDocument document = PDDocument.load(new File("F:/quarks/fichiertest/rouleau" + "/" + "2020-01" + ".pdf"));    )
                {
                    System.out.println("\nVfichierrr.pdf\n-------------\n");
                    printSubwords(document, "00090");
                  //printSubwords(document, "${var 2}");
                }
            }
}