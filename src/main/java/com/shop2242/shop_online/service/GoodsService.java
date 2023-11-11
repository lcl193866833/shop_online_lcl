package com.shop2242.shop_online.service;

import com.shop2242.shop_online.common.result.PageResult;
import com.shop2242.shop_online.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop2242.shop_online.query.Query;
import com.shop2242.shop_online.query.RecommendByTabGoodsQuery;
import com.shop2242.shop_online.vo.IndexTabRecommendVO;
import com.shop2242.shop_online.vo.RecommendGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 首页热门推荐 - 根据 tab Id 获取该推荐下的商品列表
     *
     * @return
     */
    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);

    /**
     * 首页推荐 - 猜你喜欢(分页)
     *
     * @param query
     * @return
     */
    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);

}
