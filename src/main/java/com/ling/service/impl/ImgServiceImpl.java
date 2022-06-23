package com.ling.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ling.entity.Book;
import com.ling.entity.Images;
import com.ling.mapper.BookMapper;
import com.ling.mapper.ImgMapper;
import com.ling.service.BookService;
import com.ling.service.ImgService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ling
 * @since 2022-06-09
 */
@Service
public class ImgServiceImpl extends ServiceImpl<ImgMapper, Images> implements ImgService {

}
