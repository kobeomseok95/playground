package com.example.jpashop.util;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.dto.ItemDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AlbumMapper {

    AlbumMapper albumMapper = Mappers.getMapper(AlbumMapper.class);

    Album albumDtoToAlbum(ItemDto.AlbumDto request);
}
