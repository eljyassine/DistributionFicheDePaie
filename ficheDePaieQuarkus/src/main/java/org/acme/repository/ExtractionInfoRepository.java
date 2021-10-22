package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.ExtractionInfoModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExtractionInfoRepository implements PanacheRepository<ExtractionInfoModel>{

}
