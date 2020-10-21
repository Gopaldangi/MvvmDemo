package com.demo.ui.base


import com.demo.data.local.AppPreference
import com.demo.appUtils.NetworkResponseCallback
import java.io.Serializable
import java.util.*


abstract class BaseModel<S, T> : Serializable {
    abstract fun doNetworkRequest(requestParam: HashMap<S, T>,
                                  mFitnessPreference: AppPreference, networkResponseCallback: NetworkResponseCallback<*>
    )
}

