package com.lph.finallphbaseproject.data.repository.request

import com.lph.baselib.network.bean.ProjectResponse
import com.lph.finallphbaseproject.data.model.HomeArticleBean
import com.lph.finallphbaseproject.data.model.HomeData
import com.lph.finallphbaseproject.utils.network.mApiService
import com.lph.lphmvvmbaseproject.data.model.bean.HomeBannerBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext


val HttpRequestCoroutine:HTTPRequestManager by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
    HTTPRequestManager()
}

class HTTPRequestManager {

    suspend fun getBanner(): ProjectResponse<ArrayList<HomeBannerBean>> {
            return mApiService.getBanner()
    }

    suspend fun getHomeArticle(pageNo:Int):ProjectResponse<HomeArticleBean>{
            return mApiService.getHomeArticle(pageNo)
    }




    suspend fun getHomeData(): HomeData {
        val homedata  = withContext(Dispatchers.IO){
            val banner = async { getBanner() }
            val homeArticle = async { getHomeArticle(0) }

          HomeData( banner.await(),homeArticle.await())

        }
        return homedata
    }


}