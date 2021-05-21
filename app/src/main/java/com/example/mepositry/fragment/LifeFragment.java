package com.example.mepositry.fragment;



        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.example.mepositry.R;

public class LifeFragment extends Fragment {
    public static LifeFragment newInstance(String info) {
        Bundle args = new Bundle();
        LifeFragment fragment = new LifeFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_life,null);
        return view;
    }
}
