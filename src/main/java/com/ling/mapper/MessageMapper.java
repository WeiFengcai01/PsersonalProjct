package com.ling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.entity.Book;
import com.ling.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ling
 * @since 2022-06-09
 */

@Repository
public interface MessageMapper extends BaseMapper<Message> {

}
