package by.volkov.consumer.mapper;

import by.volkov.consumer.entity.RateEntity;
import by.volkov.consumer.record.RateImportMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RateMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currencyName", source = "name")
    @Mapping(target = "rateDate", source = "date")
    RateEntity toEntity(RateImportMessage message);
}
