package com.ling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.entity.Book;
import com.ling.entity.Message;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ling
 * @since 2022-06-09
 */
public interface MessageMapper extends BaseMapper<Message> {
    int upagree(@Param("id") int id);
}
