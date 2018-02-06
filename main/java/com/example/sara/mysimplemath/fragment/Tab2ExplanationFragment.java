package com.example.sara.mysimplemath.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.activity.TabLessonActivity;

import io.github.kexanie.library.MathView;

/**
 * Explanation2 tab
 *
 * It is part of TabLessonActivity
 */
public class Tab2ExplanationFragment extends Fragment {;
    String cardTitle;

    public TextView textView_tab2Expl_Title;
    public TextView textView_tab2Expl_1;
    public TextView textView_tab2Expl_2;
    public TextView textView_tab2Expl_3;
    public TextView textView_tab2Expl_4;
    public MathView mathView_tab2Expl_2;
    public MathView mathView_tab2Expl_3;
    ImageView imageView_tab2Expl_1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout =inflater.inflate(R.layout.tab2_explanation, container, false);

        cardTitle = ((TabLessonActivity)getActivity()).getCardTitle();

        textView_tab2Expl_Title = (TextView) layout.findViewById(R.id.textView_tab2Expl_Title);
        textView_tab2Expl_1 = (TextView) layout.findViewById(R.id.textView_tab2Expl_1);
        textView_tab2Expl_2 = (TextView) layout.findViewById(R.id.textView_tab2Expl_2);
        textView_tab2Expl_3 = (TextView) layout.findViewById(R.id.textView_tab2Expl_3);
        textView_tab2Expl_4 = (TextView) layout.findViewById(R.id.textView_tab2Expl_4);
        mathView_tab2Expl_2= (MathView) layout.findViewById(R.id.mathView_tab2Expl_2);
        mathView_tab2Expl_3 = (MathView) layout.findViewById(R.id.mathView_tab2Expl_3);
        imageView_tab2Expl_1 = (ImageView) layout.findViewById(R.id.imageView_tab2Expl_1);

        setData();

        return layout;
    }

    private void setData() {
        if(cardTitle.equals("Derivative rules \n")){
            textView_tab2Expl_Title.setText("Derivation of quotient of functions");
            textView_tab2Expl_1.setText("Quotient rule:");
            textView_tab2Expl_2.setText("f(x)=g(x)/h(x) => f'(x)=(g'(x)•h(x)-g(x)•h'(x))/(h(x)^2)");
            textView_tab2Expl_3.setText("Derivation of a complex function");
            textView_tab2Expl_4.setText("f(x)=g(h(x)) => f'(x)= g'(h(x)) • h'(x)");
        }
        else if(cardTitle.equals("Derivatives \napplications")){
            textView_tab2Expl_Title.setText("Derivations applications");
            textView_tab2Expl_1.setText("Function f(x) increases at some interval <a,b> if and only if f'(x)>0 ∀ϵ<a,b>. \nFunction f(x) decreases at some interval <a,b> if and only if f'(x)<0 ∀ϵ<a,b>.");
            textView_tab2Expl_2.setText("Stationary point or critical point is a point where the function stops increasing or decreasing i.e. f'(x)=0.");
            textView_tab2Expl_3.setText("Stationary points are easy to visualize on the graph of a function of one variable: they correspond to the points on the graph where the tangent is horizontal (i.e., parallel to the x-axis).");
            textView_tab2Expl_4.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Derivatives of elementary \nfunctions")){
            textView_tab2Expl_Title.setText("Derivations of elementary functions");
            textView_tab2Expl_1.setText("Logarithmic functions:");
            textView_tab2Expl_2.setText("f(x) = a^x  => f'(x) = (a^x)•ln(a) \n f(x) = e^x => f'(x) = e^x");
            textView_tab2Expl_3.setText("Exponential functions:");
            textView_tab2Expl_4.setText("f(x) = log_a(x)  => f'(x) = 1 / (x•ln(a)) \n f(x) = ln(x) => f'(x) = 1/x");
        }
        else if(cardTitle.equals("Determining local extremes \n")) {
            textView_tab2Expl_Title.setText("Determining local extremes with the second derivative test");
            textView_tab2Expl_1.setText("The concavity of a function at a point is given by its second derivative: A positive second derivative means the function is concave up, a negative second derivative means the function is concave down, and a second derivative of zero is inconclusive (the function could be concave up or concave down, or there could be an inflection point there).");
            textView_tab2Expl_2.setText("To use the second derivative test, you first have to compute the critical numbers, then plug those numbers into the second derivative and note whether your results are positive, negative, or zero.");
            textView_tab2Expl_3.setVisibility(View.GONE);
            textView_tab2Expl_4.setVisibility(View.GONE);
        }

/**--------------------------*/
        else if(cardTitle.equals("The concept of integrals ")){
            textView_tab2Expl_Title.setText("Definite integrals");
            textView_tab2Expl_1.setText("It is the fundamental theorem of calculus that connects differentiation with the definite integral: if f is a continuous real-valued function defined on a closed interval [a, b], then, once an antiderivative F of f is known, the definite integral of f over that interval is given by.");
            mathView_tab2Expl_2.setText("\\(\\displaystyle\\int^b_a\\! f(x)dx = F(b)-F(a)\\)");
        }
        else if(cardTitle.equals("Substitution method")){
            textView_tab2Expl_Title.setText("More complicated substitution");
            textView_tab2Expl_1.setText("The steps for doing integration by substitution in this section are the same as the steps for previosu one, but we have to chose our substitution function wisely.");
            textView_tab2Expl_2.setText("Let's review it in the next example.");
        }
        else if(cardTitle.equals("Partial Integration")){
            textView_tab2Expl_Title.setText("Partial integration twice");
            textView_tab2Expl_1.setText("Sometimes more complicated integrals demand partial integration more then ones. It is usually twice.");
            textView_tab2Expl_2.setText("In the next example we will see how to do partial integration twice.");
        }
        else if(cardTitle.equals("Definite integrals")){
            textView_tab2Expl_Title.setText("Partial integration for definite integrals");
            textView_tab2Expl_1.setText("Partial integration for definite integrals in different from indefinite integrals only in formula. Steps are the same.");
            mathView_tab2Expl_2.setText("\\(\\displaystyle\\int^b_a\\! udv = (uv)|^b_a - \\displaystyle\\int^b_a\\! v du\\)");
            textView_tab2Expl_3.setText("Steps for partial integration: \nSTEP 1: Identify u and dv. Priorities for Choosing u are: 1. u = lnx 2. u = x^n 3. u = e^(ax)\nSTEP 2: Compute du and v \nSTEP 3: Use the formula for partial integration for definite integrals");
        }
/**--------------------------*/
        else if(cardTitle.equals("Polynomial")){
            textView_tab2Expl_Title.setText("Introduction to cubic function");
            textView_tab2Expl_1.setText("In algebra, a cubic function is a function of the form : ");
            mathView_tab2Expl_2.setText("\\(f(x) = ax^3 + bx^2 + cx + d\\)");
            textView_tab2Expl_3.setText("in which a is nonzero.");
            textView_tab2Expl_4.setText("Example of graph of a cubic function with 3 real roots (where the curve crosses the horizontal axis—where y = 0). The case shown has two critical points. ");
            imageView_tab2Expl_1.setImageResource(R.drawable.cubic_graph);

        }
        else if(cardTitle.equals("Trigonometric function")){
            textView_tab2Expl_Title.setText("Trigonometric function");
            textView_tab2Expl_1.setText("The previous example showed how to change things around for the amplitude and the period. The next example shows how to move things around for a vertical shift.");
        }
        else if(cardTitle.equals("Exponential function")){
            textView_tab2Expl_Title.setText("Exponential function");
            textView_tab2Expl_1.setText("The previous example showed how to draw graph that has positive exponent. In the next we will demonstrate what to do when it's negative. ");
        }
        else if(cardTitle.equals("Logarithmic function")){
            textView_tab2Expl_Title.setText("Logarithmic function");
            textView_tab2Expl_1.setText("The previous example showed how to draw graph that has only x for an argument. In the next example we will demonstrate what to do when argument is more complex");
        }

/**--------------------------*/
        else if(cardTitle.equals("Polynomial\n")){
            textView_tab2Expl_Title.setText("Introduction to cubic equation");
            textView_tab2Expl_1.setText("A cubic equation has the form : ");
            mathView_tab2Expl_2.setText("\\(ax^3 + bx^2 + cx + d = 0 , a\\neq 0\\)");
            textView_tab2Expl_3.setText("Just as a quadratic equation may have two real roots, so a cubic equation has possibly three. But unlike a quadratic equation which may have no real solution, a cubic equation always has at least one real root");
            textView_tab2Expl_4.setText(" Cubic function can have three roots, two or even all three of them may be repeated.");
        }
        else if(cardTitle.equals("Trigonometric equation")){
            textView_tab2Expl_Title.setText("Complex trigonometric equations");
            textView_tab2Expl_1.setText("Complex trigonometric equations are solved with trigonometric formulas that transforms them into simple trigonometric equations");
            mathView_tab2Expl_2.setText("\\(sin^2(x) + cos^2(x)=1\\) \\(sin(x) + sin(y) = 2 sin(\\frac{x+y}{2})+cos(\\frac{x-y}{2})\\) \\(cos(x) + cos(y) = 2 cos(\\frac{x+y}{2})+cos(\\frac{x-y}{2})\\)  \\(sin(x)*cos(y) =\\frac{1}{2}[sin(x+y)+sin(x-y)]\\) \\(sin(x)*sin(y) =\\frac{1}{2}[cos(x-y)-cos(x-y)]\\) \\(cos(x)*cos(y) =\\frac{1}{2}[cos(x+y)+cos(x-y)]\\) \\(sin(x\\pm y) = sin(x)cos(y) \\pm cos(x)sin(y)\\) \\(cos(x\\pm y) = cos(x)cos(y) \\mp sin(x)sin(y)\\)");
        }
        else if(cardTitle.equals("Exponential equation")){
            textView_tab2Expl_Title.setText("Exponential equation:");
            textView_tab2Expl_1.setText("Not all exponential equations are given in terms of the same base on either side of the \"equals\" sign. Sometimes we first need to convert one side or the other (or both) to some other base before we can set the powers equal to each other.");
        }
        else if(cardTitle.equals("Logarithmic equation")){
            textView_tab2Expl_Title.setText("Logarithmic equation");
            textView_tab2Expl_1.setText("Logarithms cannot have non-positive arguments (that is, arguments which are negative or zero), but quadratics and other equations can have negative solutions. When we convert a log equation to a different type of equation by equating the insides of the logs, we may be \"creating\" solutions that didn't previously exist. Because of this, it is generally a good idea to check the solutions you get for log equations.\n\n To check our last solution, we'll plug our solution value of x = 1 into each side of the equation, and see if we get the same value for each side:");
            mathView_tab2Expl_2.setText("the left-hand side: \\(log_b(x^2) = log_b(1^2) = log_b(1) = 0\\)");
            mathView_tab2Expl_3.setText("the right-hand side: \\(log_b(2x-1)\\) = \\(log_b(2*1-1) \\)= \\(log_b(1)\\) = 0");
            textView_tab2Expl_4.setText("The fact that each side of the original equation evaluated to the same value (in this case, to the value of zero) proves that our solution is correct.");
        }
    }
}
