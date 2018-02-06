package com.example.sara.mysimplemath.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.other.Lesson;
import com.example.sara.mysimplemath.other.LessonAdapter;

/**
        * Lesson activity
        * Activity contains CardView
        * After you choose part of math that you want to study then this activity opens a selection of smaller part of that field
        */
import java.util.ArrayList;
import java.util.List;

public class LessonActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LessonAdapter adapter;
    private List<Lesson> lessonList;
    private CardView card;
    private TextView viewTitleOfActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        viewTitleOfActivity =(TextView) findViewById(R.id.text_backdrop_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.lesson_toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        lessonList = new ArrayList<>();
        adapter = new LessonAdapter(this, lessonList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareLesson();
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding lessons cardviews data
     */
    private void prepareLesson() {
        String lesson_tip= getIntent().getStringExtra("Lesson_tip");
        viewTitleOfActivity.setText(lesson_tip);
        if(lesson_tip.equals("Derivations")){
            int[] lessonBackgrounds = new int[]{
                    R.drawable.lessons1,
                    R.drawable.lessons2,
                    R.drawable.lessons3,
                    R.drawable.lessons4,
            };

            Lesson l = new Lesson("Derivative rules \n", "", lessonBackgrounds[0]);
            lessonList.add(l);

            l = new Lesson("Derivatives \napplications", " ", lessonBackgrounds[1]);
            lessonList.add(l);

            l = new Lesson("Derivatives of elementary \nfunctions", " ", lessonBackgrounds[2]);
            lessonList.add(l);

            l = new Lesson("Determining local extremes \n", " ", lessonBackgrounds[3]);
            lessonList.add(l);
        }
        else if(lesson_tip.equals("Integrals")){
            int[] lessonBackgrounds = new int[]{
                    R.drawable.lessons1,
                    R.drawable.lessons2,
                    R.drawable.lessons3,
                    R.drawable.lessons4,
            };

            Lesson l = new Lesson("The concept of integrals ", "", lessonBackgrounds[0]);
            lessonList.add(l);

            l = new Lesson("Substitution method", "", lessonBackgrounds[1]);
            lessonList.add(l);

            l = new Lesson("Partial Integration", "", lessonBackgrounds[2]);
            lessonList.add(l);

            l = new Lesson("Definite integrals", "", lessonBackgrounds[3]);
            lessonList.add(l);
        }
        else if(lesson_tip.equals("Functions")){
            int[] lessonBackgrounds = new int[]{
                    R.drawable.lessons1,
                    R.drawable.lessons2,
                    R.drawable.lessons3,
                    R.drawable.lessons4,
            };

            Lesson l = new Lesson("Polynomial", "", lessonBackgrounds[0]);
            lessonList.add(l);

            l = new Lesson("Trigonometric function", "", lessonBackgrounds[1]);
            lessonList.add(l);

            l = new Lesson("Exponential function", "", lessonBackgrounds[2]);
            lessonList.add(l);

            l = new Lesson("Logarithmic function", "", lessonBackgrounds[3]);
            lessonList.add(l);

        }
        else if(lesson_tip.equals("Equations")){int[] lessonBackgrounds = new int[]{
                R.drawable.lessons1,
                R.drawable.lessons2,
                R.drawable.lessons3,
                R.drawable.lessons4,
        };

            Lesson l = new Lesson("Polynomial\n", "", lessonBackgrounds[0]);
            lessonList.add(l);

            l = new Lesson("Trigonometric equation", "", lessonBackgrounds[1]);
            lessonList.add(l);

            l = new Lesson("Exponential equation", "", lessonBackgrounds[2]);
            lessonList.add(l);

            l = new Lesson("Logarithmic equation", "", lessonBackgrounds[3]);
            lessonList.add(l);
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}

