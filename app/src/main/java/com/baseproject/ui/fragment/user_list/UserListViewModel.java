package com.baseproject.ui.fragment.user_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.baseproject.data.local.table.UserEntity;
import com.baseproject.data.remote.model.Resource;
import com.baseproject.data.remote.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Article List view model
 * <p>
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
public class UserListViewModel extends ViewModel {
    private final LiveData<Resource<List<UserEntity>>> popularArticles;

    @Inject
    public UserListViewModel(UserRepository userRepository) {
        popularArticles = userRepository.loadUsers(0);
    }

    public LiveData<Resource<List<UserEntity>>> getUsers() {
        return popularArticles;
    }
}
