package com.lph.finallphbaseproject.data.model

import com.lph.baselib.network.bean.ProjectResponse
import com.lph.lphmvvmbaseproject.data.model.bean.HomeBannerBean

data class HomeData (var homeBanner:ProjectResponse<ArrayList<HomeBannerBean>>,var homeArticle:ProjectResponse<HomeArticleBean>){
}