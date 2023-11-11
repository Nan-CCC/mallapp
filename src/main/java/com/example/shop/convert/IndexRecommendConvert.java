package com.example.shop.convert;

import com.example.shop.VO.IndexRecommendVO;

import com.example.shop.entity.IndexRecommend;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;


@Mapper
public interface IndexRecommendConvert {
    IndexRecommendConvert INSTANCE = Mappers.getMapper(IndexRecommendConvert.class);

    @Mapping(expression = "java(MapStruct.strToList(indexRecommend.getPictures()))", target = "pictures")
    IndexRecommendVO convertToIndexRecommendVo(IndexRecommend indexRecommend);

    List<IndexRecommendVO> convertToUserVoList(List<IndexRecommend> list);

    class MapStruct {
        public static List<String> strToList(String str) {
            if (StringUtils.isNotEmpty(str)) {
                return Arrays.asList(str.split(","));
            }
            return null;
        }
    }
}
