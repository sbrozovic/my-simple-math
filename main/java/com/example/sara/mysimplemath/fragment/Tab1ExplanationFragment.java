package com.example.sara.mysimplemath.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.activity.TabLessonActivity;

import io.github.kexanie.library.MathView;

/**
 * Explanation1 tab
 *
 * It is part of TabLessonActivity
 */
public class Tab1ExplanationFragment extends Fragment {
    String cardTitle;
    Toolbar toolbar;

    public TextView textView_tab1Expl_Title;
    public TextView textView_tab1Expl_1;
    public TextView textView_tab1Expl_2;
    public TextView textView_tab1Expl_3;
    public TextView textView_tab1Expl_4;
    public ImageView imageView_tab1Expl;
    MathView mathView_tab1Expl_1;
    MathView mathView_tab1Expl_2;
    MathView mathView_tab1Expl_3;
    TextView textView_tab1Expl_5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab1_explanation, container, false);

        cardTitle = ((TabLessonActivity)getActivity()).getCardTitle();
        toolbar = ((TabLessonActivity)getActivity()).getToolbar();

        textView_tab1Expl_Title = (TextView) layout.findViewById(R.id.textVIew_tab1Expl_Title);
        textView_tab1Expl_1 = (TextView) layout.findViewById(R.id.textView_tab1Expl_1);
        textView_tab1Expl_2 = (TextView) layout.findViewById(R.id.textView_tab1Expl_2);
        textView_tab1Expl_3 = (TextView) layout.findViewById(R.id.textView_tab1Expl_3);
        textView_tab1Expl_4 = (TextView) layout.findViewById(R.id.textView_tab1Expl_4);
        imageView_tab1Expl = (ImageView) layout.findViewById(R.id.imageView_tab1Expl);
        mathView_tab1Expl_1 = (MathView) layout.findViewById(R.id.mathView_tab1Expl_1);
        mathView_tab1Expl_2 = (MathView) layout.findViewById(R.id.mathView_tab1Expl_2);
        mathView_tab1Expl_3 = (MathView) layout.findViewById(R.id.mathView_tab1Expl_3);
        textView_tab1Expl_5 = (TextView) layout.findViewById(R.id.textView_tab1Expl_5);

        setdata();

        return layout;
    }

    private void setdata() {
        if(cardTitle.equals("Derivative rules \n")){
            toolbar.setTitle("Derivative rules");
            textView_tab1Expl_Title.setText("Derivation of sum and product of functions");
            textView_tab1Expl_1.setText("Sum rule (number of members isn't limited, each one is derived separately):");
            textView_tab1Expl_2.setText("f(x) = g(x)+h(x) =>  f'(x) = g'(x)+h'(x)");
            textView_tab1Expl_3.setText("Product rule:");
            textView_tab1Expl_4.setText("f(x) = g(x)•h(x) =>  f'(x) = g'(x)•h(x) + g(x)•h'(x) ");
        }
        else if(cardTitle.equals("Derivatives \napplications")){
            toolbar.setTitle("Derivatives applications");
            textView_tab1Expl_Title.setText("Derivations applications");
            textView_tab1Expl_1.setText("The slope of the graph of a function f in point (x1, y1) is defined as the slope of the tangent to the graph in that point.");
            textView_tab1Expl_2.setText("The slope of the tangent k is related to its angle of incline α : k=tg(α) = f'(x1)");
            textView_tab1Expl_3.setText("Equation of the tangent to the graph can be found by using the point-slope formula:");
            textView_tab1Expl_4.setText("y - y1 = k (x - x1)");
            imageView_tab1Expl.setImageResource(R.drawable.slope_graph);
        }
        else if(cardTitle.equals("Derivatives of elementary \nfunctions")){
            toolbar.setTitle("Derivatives of elementary functions");
            textView_tab1Expl_Title.setText("Derivations of elementary functions");
            textView_tab1Expl_1.setText("Basic:");
            textView_tab1Expl_2.setText("f(x) = c => f'(x) = 0  \nf(x) = x^n => f'(x) = n•x^(n-1) \nf(x) = 1/(x^n) => f'(x) = - n / (x^(n+1))");
            textView_tab1Expl_3.setText("Trigonometric functions:");
            textView_tab1Expl_4.setText("f(x) = sin(x) => f'(x) = cos(x) \nf(x) = cos(x) => f'(x) = -sin(x) \nf(x) = tg(x) => f'(x) = 1/(cos(x)^2) \nf(x) = ctg(x) => f'(x) = - 1/(sin(x)^2)");
        }
        else if(cardTitle.equals("Determining local extremes \n")){
            toolbar.setTitle("Determining local extremes");
            textView_tab1Expl_Title.setText("Determining local extremes with the first derivative test");
            textView_tab1Expl_1.setText("The first step in finding a function’s local extrema is to find its critical numbers (the x-values of the critical points).");
            textView_tab1Expl_2.setText("1. Find the first derivative of f using the power rule. \n2. Set the derivative equal to zero and solve for x.");
            textView_tab1Expl_3.setText("Now you need to determine whether peaks or valleys or neither occur at those x-values. You can do this with the First Derivative Test.");
            textView_tab1Expl_4.setText("1. Take a number line and put down the critical numbers you have found. \n2. Pick a value from each region, plug it into the first derivative, and note whether your result is positive or negative. \n3. Take your number line, mark each region with the appropriate positive or negative sign, and indicate where the function is increasing and decreasing. \n4. Obtain the function values (in other words, the heights) of these two local extrema by plugging the x-values into the original function.");
        }

/**--------------------------*/
        else if(cardTitle.equals("The concept of integrals ")){
            toolbar.setTitle("The concept of integrals");
            textView_tab1Expl_Title.setText("Indefinite integrals");
            textView_tab1Expl_1.setText("Integration is a way of adding slices to find the whole. It can be used to find areas, volumes, central points and many useful things.");
            textView_tab1Expl_2.setText("The operation of integration is the reverse of differentiation. For this reason, the term integral may also refer to the related notion of the antiderivative, a function F whose derivative is the given function f. In this case, it is called an indefinite integral and is written:");
            textView_tab1Expl_3.setText("F(x) = ∫ f(x)dx");
            textView_tab1Expl_4.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Substitution method")){
            toolbar.setTitle("Substitution method");
            textView_tab1Expl_Title.setText("Simple substitution");
            textView_tab1Expl_1.setText("The substitution method turns an unfamiliar integral into one we can evaluate. In other words, substitution gives us a simpler integral involving the variable u.");
            textView_tab1Expl_2.setText("Let's now review the five steps for integration by substitution.");
            textView_tab1Expl_3.setText("Step 1: Choose a new variable u\nStep 2: Determine the value dx\nStep 3: Make the substitution\nStep 4: Integrate resulting integral\nStep 5: Return to the initial variable x");
        }
        else if(cardTitle.equals("Partial Integration")) {
            toolbar.setTitle("Partial integration");
            textView_tab1Expl_Title.setText("Introduction to partial integration");
            textView_tab1Expl_1.setText("Partial integration is a theorem that relates the integral of a product of functions to the integral of their derivative and antiderivative. It is frequently used to transform the antiderivative of a product of functions into an antiderivative for which a solution can be more easily found. The rule can be derived in one line simply by integrating the product rule of differentiation.");
            textView_tab1Expl_2.setText("The formula for the method of integration by parts is given by:");
            textView_tab1Expl_3.setText("∫ u dv = u•v - ∫vdu");
            textView_tab1Expl_4.setText("There are 3 steps tu use this formula \nSTEP 1: Identify u and dv. Priorities for Choosing u are: 1. u = lnx 2. u = x^n 3. u = e^(ax)\nSTEP 2: Compute du and v \nSTEP 3: Use the formula for the integration by parts");
        }
        else if(cardTitle.equals("Definite integrals")){
            toolbar.setTitle("Definite integrals");
            textView_tab1Expl_Title.setText("Substitution for definite integrals");
            textView_tab1Expl_1.setText("Substitution in definite integrals is quite similar to indefinite integrals.");
            textView_tab1Expl_2.setText("Let's review those five steps for integration by substitution in definite integrals.");
            textView_tab1Expl_3.setText("Step 1: Choose a new variable u\nStep 2: Calculate the reverse relation x through u\nStep 3: Determine the value dx\nStep 4: Determine new limits based od relation between x and u \nStep 5: Make the substitution and calculate integral ");
        }
/**--------------------------*/
        else if(cardTitle.equals("Polynomial")){
            toolbar.setTitle("Polynomial");
            textView_tab1Expl_Title.setText("Introduction to quadratic function");
            textView_tab1Expl_1.setText("A quadratic function, a quadratic polynomial, a polynomial of degree 2, or simply a quadratic, is a polynomial function in one or more variables in which the highest-degree term is of the second degree.");
            textView_tab1Expl_2.setText("A univariate (single-variable) quadratic function has the form:");
            mathView_tab1Expl_2.setText("\\(f(x)= ax^2 + bx + c, a\\neq 0\\)");
            textView_tab1Expl_4.setText("in the single variable x. The graph of a univariate quadratic function is a parabola whose axis of symmetry is parallel to the y-axis.\n\n When you draw a graph you have to be aware if a>0 or a<0, because if a>0 the graph will look like it is \"smiling\" and if a<0 the graph will look like it is \"sad\" \n(In both examples for quadratic function, graphs will look like they are \"smiling\")");
            imageView_tab1Expl.setImageResource(R.drawable.quadratic_function);
        }
        else if(cardTitle.equals("Trigonometric function")){
            toolbar.setTitle("Trigonometric function");
            textView_tab1Expl_Title.setText("Introduction to trigonometric function");
            textView_tab1Expl_1.setText("In mathematics, the trigonometric functions (also called the circular functions) are functions of an angle. They relate the angles of a triangle to the lengths of its sides. Trigonometric functions are important in the study of triangles and modeling periodic phenomena, among many other applications.");
            textView_tab1Expl_2.setText("The most familiar trigonometric functions are the sine, cosine, and tangent. In the context of the standard unit circle (a circle with radius 1 unit), where a triangle is formed by a ray starting at the origin and making some angle with the x-axis, the sine of the angle gives the length of the y-component (the opposite to the angle or the rise) of the triangle, the cosine gives the length of the x-component (the adjacent of the angle or the run), and the tangent function gives the slope (y-component divided by the x-component). Trigonometric functions are commonly defined as ratios of two sides of a right triangle containing the angle, and can equivalently be defined as the lengths of various line segments from a unit circle. More modern definitions express them as infinite series or as solutions of certain differential equations, allowing their extension to arbitrary positive and negative values and even to complex numbers.");
            //pogledaj u udžbenik i ona stranicu koju sam spremila za trigonometrijske funkcije
        }
        else if(cardTitle.equals("Exponential function")){
            toolbar.setTitle("Exponential function");
            textView_tab1Expl_Title.setText("Introduction to exponential function");
            textView_tab1Expl_1.setText("In mathematics, an exponential function is a function of the form");
            mathView_tab1Expl_1.setText("\\(f(x)= a^x\\)");
            textView_tab1Expl_3.setText("where a>0, a≠1 and x is any rational number");
            textView_tab1Expl_4.setText("The graph of natural exponential function \ny = e^x :");
            imageView_tab1Expl.setImageResource(R.drawable.exponantial_func);
            //pogledat u knjigu i na wikipediju
        }
        else if(cardTitle.equals("Logarithmic function")){
            toolbar.setTitle("Logarithmic function");
            textView_tab1Expl_Title.setText("Introduction to logarithmic function");
            textView_tab1Expl_1.setText("If b is any number such that  and  and  then,");
            mathView_tab1Expl_1.setText("\\( y = log_b x \\Leftarrow\\Rightarrow  b^y=x\\)");
            textView_tab1Expl_3.setText("We usually read this as “log base b of x”.");
            mathView_tab1Expl_3.setText("In this definition \\( y = log_b x\\) is called the logarithm form and \\(b^y=x\\) is called the exponential form. ");
            textView_tab1Expl_4.setText("Note that the requirement that x>0 is really a result of the fact that we are also requiring b>0. \n If you think about it, it will make sense.  We are raising a positive number to an exponent and so there is no way that the result can possibly be anything other than another positive number.  It is very important to remember that we can’t take the logarithm of zero or a negative number. ");
            //pogledaj u udžbenik i ona stranicu koju sam spremila za logaritamske funkcije
        }

/**--------------------------*/
        else if(cardTitle.equals("Polynomial\n")){
            toolbar.setTitle("Polynomial");
            textView_tab1Expl_Title.setText("Introduction to quadratic equation");
            textView_tab1Expl_1.setText("In algebra, a quadratic equation is any equation having the form:");
            mathView_tab1Expl_1.setText("\\(a*x^2 + b*x + c = 0\\)");
            textView_tab1Expl_3.setText("where x represents an unknown, and a, b, and c represent known numbers such that a is not equal to 0. If a = 0, then the equation is linear, not quadratic. The numbers a, b, and c are the coefficients of the equation, and may be distinguished by calling them, respectively, the quadratic coefficient, the linear coefficient and the constant or free term.");
            textView_tab1Expl_4.setText("The quadratic formula for the roots of the general quadratic equation:");
            mathView_tab1Expl_3.setText("\\( x = \\frac{-b \\pm\\sqrt{b^2-4ac}}{2a}\\)");
            textView_tab1Expl_5.setText("The solution of the equation can be two real roots, or one real root(both answers are the same), or it can have two complex solutions. ");
        }
        else if(cardTitle.equals("Trigonometric equation")){
            toolbar.setTitle("Trigonometric equation");
            textView_tab1Expl_Title.setText("Simple trigonometric equations");
            textView_tab1Expl_1.setText("Simple trigonometric equations have sin(x) or cos(x) or tg(x) or ctg(x) on one side and on the other side a number.");
            textView_tab1Expl_3.setText("Those equation need to be solved on the unit circle");
            imageView_tab1Expl.setImageResource(R.drawable.unit_circle);
        }
        else if(cardTitle.equals("Exponential equation")){
            toolbar.setTitle("Exponential equation");
            textView_tab1Expl_Title.setText("Exponential equation");
            textView_tab1Expl_1.setText("To solve exponential equations without logarithms, you need to have equations with comparable exponential expressions on either side of the \"equals\" sign, so you can compare the powers and solve. In other words, you have to have \"(some base) to (some power) equals (the same base) to (some other power)\", where you set the two powers equal to each other, and solve the resulting equation. ");
        }
        else if(cardTitle.equals("Logarithmic equation")){
            toolbar.setTitle("Logarithmic equation");
            textView_tab1Expl_Title.setText("Logarithmic equation");
            textView_tab1Expl_1.setText("The first type of logarithmic equation has two logs, each having the same base, which have been set equal to each other. We solve this sort of equation by setting the insides (that is, setting the \"arguments\") of the logarithmic expressions equal to each other.");
            mathView_tab1Expl_2.setText("\\(log_a(x*y)= log_a(x) + log_a(y)\\) \\(log_a(\\frac{x}{y})= log_a(x) - log_a(y)\\) \\(log_a(x^n)= n*log_a(x)) \\) \\(log_a(x)= \\frac{log_b(x)}{log_b(a)}\\)");
        }
    }
}
