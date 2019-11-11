package com.github.coneys.androidArchitecture.viewData

import com.github.coneys.androidArchitecture.error.ApplicationError

abstract class ViewState(showSuccess: Boolean, error: ApplicationError?)
abstract class LoadViewState(showSuccess: Boolean, error: ApplicationError?, showLoading: Boolean) :
    ViewState(showSuccess, error)