package com.baseproject.ui.fragment.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.baseproject.R
import com.baseproject.common.BUNDLE_KEY_USER_ID
import com.baseproject.data.local.table.UserEntity
import com.baseproject.data.remote.Status
import com.baseproject.data.remote.model.Resource
import com.baseproject.databinding.FragmentListUserBinding
import com.baseproject.ui.adapter.UserListAdapter
import com.baseproject.ui.base.BaseFragment
import com.baseproject.ui.callback.UserListCallback

/**
 * The article list fragment which will list the popular articles
 */
class UserListFragment : BaseFragment<UserListViewModel, FragmentListUserBinding>(),
    UserListCallback {
    public override fun getViewModel(): Class<UserListViewModel> {
        return UserListViewModel::class.java
    }

    override val layoutRes: Int
        get() = R.layout.fragment_list_user

    override fun onArticleClicked(userEntity: UserEntity) {
        if (null != activity) {
            val args = Bundle()
            args.putParcelable(BUNDLE_KEY_USER_ID, userEntity.id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)
        dataBinding.rvUsers.layoutManager = LinearLayoutManager(activity)
        dataBinding.rvUsers.adapter = UserListAdapter(this)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel.users
            .observe(
                this,
                Observer { listResource: Resource<List<UserEntity?>?>? ->
                    if (null != listResource && (listResource.status === Status.ERROR || listResource.status === Status.SUCCESS)) {
                        dataBinding.loginProgress.visibility = View.GONE
                    }
                    dataBinding.resourceModel = listResource
                    // If the cached data is already showing then no need to show the error
                    if (null != dataBinding.rvUsers.adapter && dataBinding.rvUsers.adapter!!.itemCount > 0) {
                        dataBinding.errorText.visibility = View.GONE
                    }
                }
            )
    }

    companion object {
        fun newInstance(): UserListFragment = UserListFragment().apply {
            val args = Bundle()
            val fragment = UserListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}