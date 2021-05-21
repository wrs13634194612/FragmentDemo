package com.example.mepositry.fragment;




        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

        import com.example.mepositry.FirstActivity;
        import com.example.mepositry.R;

public class CommunityFragment extends Fragment {

    public static CommunityFragment newInstance(String info) {
        Bundle args = new Bundle();
        CommunityFragment fragment = new CommunityFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_community,null);

        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FirstActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }
}
