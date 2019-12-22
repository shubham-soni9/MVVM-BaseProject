package com.baseproject.ui.callback

import com.baseproject.data.local.table.UserEntity

interface UserListCallback {
    fun onArticleClicked(userEntity: UserEntity)
}