package com.shop2242.shop_online.service;

import com.shop2242.shop_online.entity.IndexRecommend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop2242.shop_online.vo.IndexRecommendVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
public interface IndexRecommendService extends IService<IndexRecommend> {

    /**
     * 首页-热门推荐
     *
     * @return
     */
    List<IndexRecommendVO> getList();

}
