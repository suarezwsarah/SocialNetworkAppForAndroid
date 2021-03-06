package com.dogaozkaraca.izunetwork.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dogaozkaraca.izunetwork.AdapterItems.FeedItem;
import com.dogaozkaraca.izunetwork.AdapterItems.FriendItem;
import com.dogaozkaraca.izunetwork.Adapters.FeedAdapter;
import com.dogaozkaraca.izunetwork.Adapters.FriendsAdapter;
import com.dogaozkaraca.izunetwork.R;

import java.util.ArrayList;

/**
 * Izu Network
 * Created by doga on 24/04/16.
 */
public class FriendsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.friends_fragment, container, false);
        TextView noFriend = (TextView) v.findViewById(R.id.nofriendstext);
        //Load Friends

        // RecyclerView
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(inflater.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<FriendItem> feed = new ArrayList<>();
        feed.add(new FriendItem(1,"Ali","Durmaz","profileimageurl.com"));
        feed.add(new FriendItem(2,"Ayşe","Gündüz","profileimageurl.com"));
        feed.add(new FriendItem(3,"Veli","Gece","profileimageurl.com"));
        feed.add(new FriendItem(4,"Barış","Ceyhan","profileimageurl.com"));

        if (feed.isEmpty())
        {
            noFriend.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
        else
        {
            noFriend.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);


        }
        mAdapter = new FriendsAdapter(feed);
        mRecyclerView.setAdapter(mAdapter);


        return v;
    }

}
