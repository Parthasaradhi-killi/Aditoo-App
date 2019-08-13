package com.kari.love.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kari.love.R;
import com.kari.love.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private ImageView mProfilePhoto;
    private ImageView mCoverPhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);

        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);
        mCoverPhoto = (ImageView) view.findViewById(R.id.cover_photo);


                                    //calling functions
        setProfileImage();
        setCoverImage();

        //back arrow for navigating to "ProfileActivity"
        ImageView backarrow = (ImageView) view.findViewById(R.id.backArrw);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Navigating to ProfileActivity");
                getActivity().finish();
            }
        });

        return view;
    }



    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: Setting profile Image");
        String imgsURL = "www.wallpapercave.com/wp/wp2664168.jpg";
        UniversalImageLoader.setImage(imgsURL, mProfilePhoto, null, "https://");

    }

    private void setCoverImage(){
        Log.d(TAG, "setCoverImage: Setting cover image");
        String imgeURL = "www.wallpapercave.com/wp/wp2664168.jpg";
        UniversalImageLoader.setImage(imgeURL, mCoverPhoto, null, "https://");
    }


}
