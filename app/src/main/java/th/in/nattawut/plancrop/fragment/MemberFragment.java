package th.in.nattawut.plancrop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import th.in.nattawut.plancrop.AdminActivity;
import th.in.nattawut.plancrop.MemberActivity;
import th.in.nattawut.plancrop.R;

public class MemberFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        homeController();

        memberController();

        ordertController();

        selectOrDerController();

        plantReportallController();

        CreateToolbal();

        PlantResultController();


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemSingOut) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.manu_exit,menu);

    }

    private void CreateToolbal() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarMemberActivity);
        ((MemberActivity)getActivity()).setSupportActionBar(toolbar);

         String nameString = getActivity().getIntent().getStringExtra("name");
        ((MemberActivity)getActivity()).getSupportActionBar().setTitle("สมาชิก : คุณ " + nameString);
        //((MemberActivity)getActivity()).getSupportActionBar().setSubtitle(nameString);

        ((MemberActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MemberActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.mipmap.ic_appnattawut1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMemberFragment,new HomeFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });
        setHasOptionsMenu(true);

    }



    private void homeController() {
        CardView Requirement = getView().findViewById(R.id.CardViewHome);
        Requirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMemberFragment, new HomeFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void memberController() {
        CardView Requirement = getView().findViewById(R.id.CardViewMember);
        Requirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMemberFragment, new MemberViewFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }


    private void plantReportallController() {
        CardView Requirement = getView().findViewById(R.id.CardViewPlantReportall);
        Requirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMemberFragment, new PlantReportallViewFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
    private void ordertController() {
        CardView Requirement = getView().findViewById(R.id.CardViewAddOrder);
        Requirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMemberFragment, new OrderViewFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
    private void selectOrDerController() {
        CardView Requirement = getView().findViewById(R.id.CardViewSelectOrder);
        Requirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMemberFragment, new OrderViewRePortFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void PlantResultController() {
        CardView imageViewPlantResult = getView().findViewById(R.id.imageViewPlantResult);
        imageViewPlantResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                checkStatus();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMemberFragment, new PlantResultViewFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member, container, false);
        return view;
    }
}
