package com.demo.ui.base

import com.demo.appUtils.NetworkResponseCallback
import com.google.gson.annotations.SerializedName
import java.util.HashMap
import io.reactivex.disposables.Disposable


abstract class BaseResponse<T, K, V> {



    /**
     * This method is used to call api and handel response.
     *
     * @param HashMap contains values to send in api.
     * @param  vararg variable arguments can accept arbitrary number of values.
     * @param NetworkResponseCallback method which handel api response.
     */
    abstract fun doNetworkRequest(requestParam: HashMap<K, V>, vararg: Any, networkResponseCallback: NetworkResponseCallback<T>): Disposable
}
