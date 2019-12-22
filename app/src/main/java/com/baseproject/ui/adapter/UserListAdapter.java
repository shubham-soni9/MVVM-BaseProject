package com.baseproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baseproject.data.local.table.UserEntity;
import com.baseproject.databinding.ItemUserListBinding;
import com.baseproject.ui.base.BaseAdapter;
import com.baseproject.ui.callback.UserListCallback;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Article list recycler view adapter
 */
public class UserListAdapter extends BaseAdapter<UserListAdapter.UserViewHolder, UserEntity> {

    private List<UserEntity> userEntities;

    private final UserListCallback articleListCallback;

    public UserListAdapter(@NonNull UserListCallback articleListCallback) {
        userEntities = new ArrayList<>();
        this.articleListCallback = articleListCallback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return UserViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, articleListCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder viewHolder, int i) {
        viewHolder.onBind(userEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return userEntities.size();
    }

    @Override
    public void setData(@Nullable List<? extends UserEntity> entities) {
        this.userEntities = (List<UserEntity>) entities;
        notifyDataSetChanged();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private static UserViewHolder create(LayoutInflater inflater, ViewGroup parent, UserListCallback callback) {
            ItemUserListBinding itemMovieListBinding = ItemUserListBinding.inflate(inflater, parent, false);
            return new UserViewHolder(itemMovieListBinding, callback);
        }

        final ItemUserListBinding binding;

        private UserViewHolder(ItemUserListBinding binding, UserListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v -> callback.onArticleClicked(binding.getUserEntity()));
        }

        private void onBind(UserEntity articleEntity) {
            binding.setUserEntity(articleEntity);
            binding.executePendingBindings();
        }
    }
}
