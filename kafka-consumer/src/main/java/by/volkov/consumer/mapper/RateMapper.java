package by.volkov.consumer.mapper;

import by.volkov.consumer.model.RateEntity;
import by.volkov.consumer.record.RateImportMessage;
import by.volkov.consumer.vm.RateVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RateMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currencyName", source = "name")
    @Mapping(target = "rateDate", source = "date")
    RateEntity toEntity(RateImportMessage message);

    RateVM toVM(RateEntity rateEntity);

    List<RateVM> toVMs(List<RateEntity> entities);
}
