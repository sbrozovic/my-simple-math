package com.example.sara.mysimplemath.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
 * Question tab
 *
 * It is part of TabLessonActivity
 */
public class TabExample2Fragment extends Fragment {
    String cardTitle;
    MathView mathView_tabExample2_task;
    TextView textView_tabExample2_1;
    MathView mathView_tabExample2_2;
    TextView textView_tabExample2_3;
    MathView mathView_tabExample2_4;
    TextView textView_tabExample2_5;
    MathView mathView_tabExample2_6;
    MathView mathView_tabExample2_3;
    TextView textView_tabExample2_7;
    ImageView imageView_tabExample2_1;
    ImageView imageView_tabExample2_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab_example2, container, false);
        cardTitle = ((TabLessonActivity)getActivity()).getCardTitle();

        mathView_tabExample2_task= (MathView) layout.findViewById(R.id.mathView_tabExample2_task);
        textView_tabExample2_1 = (TextView) layout.findViewById(R.id.textView_tabExample2_1) ;
        mathView_tabExample2_2 = (MathView) layout.findViewById(R.id.mathView_tabExample2_2);
        textView_tabExample2_3 = (TextView) layout.findViewById(R.id.textView_tabExample2_3) ;
        mathView_tabExample2_4 = (MathView) layout.findViewById(R.id.mathView_tabExample2_4);
        textView_tabExample2_5 = (TextView) layout.findViewById(R.id.textView_tabExample2_5) ;
        mathView_tabExample2_6 = (MathView) layout.findViewById(R.id.mathView_tabExample2_6);
        mathView_tabExample2_3 = (MathView) layout.findViewById(R.id.mathView_tabExample2_3);
        textView_tabExample2_7 = (TextView) layout.findViewById(R.id.textView_tabExample2_7);
        imageView_tabExample2_1 = (ImageView) layout.findViewById(R.id.imageView_tabExample2_1);
        imageView_tabExample2_3 = (ImageView) layout.findViewById(R.id.imageView_tabExample2_3);
        setData();
        return layout;
    }

    private void setData() {
        if(cardTitle.equals("Derivative rules \n")){
            mathView_tabExample2_task.setText("Derivate: \\((\\frac{x^2+x-1}{4})'\\)");
            textView_tabExample2_1.setText("For this we will use quotient rule:");
            mathView_tabExample2_2.setText("\\((\\frac{x^2+x-1}{4})' \\) =\\( \\frac{(x^2+x-1)'*4 - (x^2+x-1)*4'}{4^2} =\\) \\(\\frac{4*(2x+1)-(x^2+x-1)*0}{16} =\\)\\( \\frac{2x+1}{4}\\)");
            textView_tabExample2_3.setVisibility(View.INVISIBLE);
            textView_tabExample2_5.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Derivatives \napplications")){
            mathView_tabExample2_task.setText("Well done!!");
            textView_tabExample2_3.setText("This is the end of derivations applications.");
            textView_tabExample2_5.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Derivatives of elementary \nfunctions")){
            mathView_tabExample2_task.setText("Here will be demonstrated how to derivate some elementary functions.");
            textView_tabExample2_1.setText("Here are some examples:");
            mathView_tabExample2_2.setText("\\((10^x)'= 10^x*ln(a)\\)");
            mathView_tabExample2_4.setText("\\((log_{10}(x))' = \\frac{1}{x*ln(10)}\\)");
            textView_tabExample2_3.setVisibility(View.INVISIBLE);
            textView_tabExample2_5.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Determining local extremes \n")){
            mathView_tabExample2_task.setText("We well use previous example for explaining second derivative test: \\(f(x)=3*x^5 - 20*x^3\\)");
            textView_tabExample2_1.setText("After you find critical numbers of f, plug those critical numbers into the second derivative. In our case critical number are x = 0, –2, or 2.");
            mathView_tabExample2_2.setText("Second derivative is : \\(f(x)=3*x^5 - 20*x^3 => f'(x)=15*x^4-60*x^2 => f''(x)=60*x^3-120*x \\)");
            textView_tabExample2_3.setText("Now we will put critical numbers into second derivative:");
            mathView_tabExample2_4.setText("\\(f''(-2)=60(-2)^3 -120(-2)=-240\\) \\(f''(0)=60(0)^3 -120(0)=0\\)  \\(f''(2)=60(2)^3 -120(2)=240\\)");
            textView_tabExample2_5.setText("At –2, the second derivative is negative (–240). This tells you that f is concave down where x equals –2, and therefore that there’s a local max at –2. The second derivative is positive (240) where x is 2, so f is concave up and thus there’s a local min at x = 2. Because the second derivative equals zero at x = 0, the Second Derivative Test fails — it tells you nothing about the concavity at x = 0 or whether there’s a local min or max there. When this happens, you have to use the First Derivative Test. In this example, you find that there is neither a min nor a max at x = 0; there’s an inflection point there.");
        }

/**---------------------------------*/
        else if(cardTitle.equals("The concept of integrals ")){
            mathView_tabExample2_task.setText("Well done!!");
            textView_tabExample2_3.setText("This is the end of \"The concept of integrals\".");
            textView_tabExample2_5.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Substitution method")){
            mathView_tabExample2_task.setText("Evaluate \\(\\displaystyle\\int x*sin(x^2)\\)dx");
            textView_tabExample2_1.setText("Step 1: Choose a substitution function u\nThe substitution function is: u = x^2");
            mathView_tabExample2_2.setText("Step 2: Determine the value dx \n \\(u = x^2\\) \n\\((x^2)'dx = du \\)\n \\(2xdx = du\\) \n \\(xdx = \\frac{du}{2}\\)");
            mathView_tabExample2_3.setText("Step 3: Make the substitution \\(\\displaystyle\\int x*sin(x^2)dx = \\displaystyle\\int sin(u) \\frac{du}{2}\\)");
            mathView_tabExample2_4.setText("Step 4: Integrate resulting integral \n  \\(\\displaystyle\\int x*sin(x^2)dx = \\displaystyle\\int sin(u) \\frac{du}{2} =\\) \\( \\frac{1}{2} \\displaystyle\\int sin(u) du \\)= \\( -\\frac{1}{2} cos(u)+C \\)");
            textView_tabExample2_5.setText("Step 5: Return to the initial variable: x");
            mathView_tabExample2_6.setText("\\(-\\frac{1}{2} cos(u)+C = -\\frac{1}{2} cos(x^2)+C \\)");
            textView_tabExample2_3.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Partial Integration")){
            mathView_tabExample2_task.setText("Evaluate the following integral   \\(\\displaystyle\\int x^2*e^x dx\\)");
            mathView_tabExample2_2.setText("Step 1: In this example we choose \\(u = x^2\\) and dv will be everything else that remains. \\(u=x^2\\)  \\(dv=e^x dx\\)");
            mathView_tabExample2_3.setText("Step 2: Compute du and v \\(u = x^2 , dv=e^x dx  ==> du=(x^2)'dx  ,  v=\\displaystyle\\int sin(x)dx ==>  du=2xdx   ,  v=e^x \\)");
            mathView_tabExample2_4.setText("Step 3: Use the formula.  \\(\\displaystyle\\int x^2*e^x dx = 2x*e^x - \\displaystyle\\int 2xe^x dx = 2x*e^x - 2\\displaystyle\\int x*e^x dx\\)");
            textView_tabExample2_5.setText("We need to perform integration by parts again:");
            mathView_tabExample2_6.setText("\\(\\displaystyle\\int x^2*e^x dx = 2x*e^x - \\displaystyle\\int 2xe^x dx = 2x*e^x - 2\\displaystyle\\int x*e^x dx = 2x*e^x - 2(x* e^x - \\displaystyle\\int e^x dx = 2x*e^x - 2(x* e^x - e^x dx) +C = 2x*e^x - 2x* e^x + 2e^x dx +C \\)");
            textView_tabExample2_3.setVisibility(View.INVISIBLE);
        }
        else if(cardTitle.equals("Definite integrals")){
            mathView_tabExample2_task.setText("Evaluate \\(\\displaystyle\\int^e_1\\! ln(x)dx\\)");
            textView_tabExample2_1.setText("STEP 1: Identify u and dv.");
            mathView_tabExample2_2.setText("\\(u=ln(x), dv=dx\\)");
            textView_tabExample2_3.setText("STEP 2: Compute du and v:");
            mathView_tabExample2_4.setText("\\(u=ln(x) \\Longrightarrow du = \\frac{1}{x}dx\\), \\(dv=dx \\Longrightarrow \\displaystyle\\int dx = x \\)");
            textView_tabExample2_5.setText("STEP 3: Use the formula for the partial integration for definite integrals");
            mathView_tabExample2_6.setText("\\(\\displaystyle\\int^e_1\\! ln(x)dx = [(uv)|^e_1-\\displaystyle\\int^e_1\\! vdu] = xln(x)|^e_1-\\displaystyle\\int^e_1\\! dx = eln(e)-1ln(1)-x|^e_1 = e-(e-1)=1\\)");
        }
/**---------------------------------*/
        else if(cardTitle.equals("Polynomial")){
            mathView_tabExample2_task.setText("Graph \\(f(x)= x^3 - 6x^2 +11x -6\\)");
            textView_tabExample2_1.setText("In chapter one (derivations -> polinomial) we already solved the equation of this function.\n \nThe solutions are x = 1, x = 2 and x = 3. \n\nThe graph of this function is: ");
            imageView_tabExample2_1.setImageResource(R.drawable.cubic_example1);

            mathView_tabExample2_2.setText("Graph \\(f(x)=x^3+x^2+x-3\\)");
            textView_tabExample2_3.setText("In chapter one (derivations -> polinomial) we already solved the equation of this function.\n \n So because the quadratic  x^2 + 2x + 3 = 0 has no real solutions the only real solution is x = 1\n\nThe graph of this function is: ");
            imageView_tabExample2_3.setImageResource(R.drawable.cubic_example2);
            textView_tabExample2_7.setText("In the first example we noticed that function starts low down on the left, because as x gets large and negative so does x^3 and it finishes higher to the right because as x gets large and positive so does x^3. The curve crosses the x-axis three times, once where x = 1, once where x = 2 and once where x = 3. This gives us our three separate solutions.\n\n\n In the second example you can see that the graph crosses the x-axis in one place only.\n\n\n Overall, The graph of a cubic must cross the x-axis at least once giving you at least one real root. So, any problem you get that involves solving a cubic equation will have a real solution.\n");
        }
        else if(cardTitle.equals("Trigonometric function")){
            mathView_tabExample2_task.setText("Graph at least one period of f(θ) = tan(θ)–1");
            textView_tabExample2_1.setText("The regular tangent looks like this:");
            imageView_tabExample2_1.setImageResource(R.drawable.trigonom_fun4);
            textView_tabExample2_3.setText("The graph for tan(θ) – 1 is the same shape as the regular tangent graph, because nothing is multiplied onto the tangent.\n\nBut this graph is shifted down by one unit. In other words, instead of the graph's midline being the x-axis, it's going to be the line y = -1.\n\nRather than trying to figure out the points for moving the tangent curve one unit lower, we'll just erase the original horizontal axis and re-draw the axis one unit higher. Then our final (hand-in) graph looks like this:");
            imageView_tabExample2_3.setImageResource(R.drawable.trigonom_fun5);
        }
        else if(cardTitle.equals("Exponential function")){
            mathView_tabExample2_task.setText("Graph \\(y = 5^{-x}\\)");
            textView_tabExample2_1.setText("We need to remember that the \"negative\" exponent reverses the location (along the x-axis) in which the power on 5 is negative. When the x-values are negative (that is, when we are on the left-hand side of the graph), the value of –x will be positive, so the graph will grow quickly on the left-hand side. On the other hand, when the x-values are positive (that is, on the right-hand side of the graph), the value of –x will be negative, so the graph will stay very close to the x-axis.\n\nIn other words, the standard values are reversed:");
            imageView_tabExample2_1.setImageResource(R.drawable.exponent_fun5);
            textView_tabExample2_3.setText("Then y = 5–x graphs as:");
            imageView_tabExample2_3.setImageResource(R.drawable.exponent_fun6);
        }

        else if(cardTitle.equals("Logarithmic function")){
            mathView_tabExample2_task.setText("Graph \\(y = log_2(x + 3)\\)");
            textView_tabExample2_1.setText("This graph will be similar to the graph of log2(x), but it will be shifted sideways.\n\n Since the \"+ 3\" is inside the log's argument, the graph's shift cannot be up or down. This means that the shift has to be to the left or to the right. But which way? You can keep track of the direction of the shift by looking at the basic point (1, 0) (\"basic\" because it's neat and easy to remember). The log will be 0 when the argument, x + 3, is equal to 1. When is x + 3 equal to 1? When x = –2. Then the basic log-graph point of (1, 0) will be shifted over to \n" +
                    "(–2, 0) on this graph; that is, the graph is shifted three units to the left. If you are not comfortable with this concept or these manipulations, please review how to work with translations of functions. \n\nSince a log cannot have an argument of zero or less, then we must have x + 3 > 0, this tells us that, for this graph, x must always be greater than –3.\n\nThe graph of the basic log function y = log2(x) crawled up the positive side of the y-axis to reach the x-axis, with the line never going to the left of the limitation that x must be greater than zero. To remind myself of the similar limitation of this log (where x must always be greater than –3), we will insert a dashed line at x = –3:");
            imageView_tabExample2_1.setImageResource(R.drawable.logarit_fun2);
            mathView_tabExample2_2.setText("After we dash in the asymptote, we plot some points: \\(2^0 = 1, so log_2(1) = 0; x + 3 = 1 for x = -2:  (-2, 0) \\)\n" +
                    "\\(2^1 = 2, so log_2(2) = 1; x + 3 = 2 for x = -1:  (-1, 1) \\)\n" +
                    "\\(2^2 = 4, so log_2(4) = 2; x + 3 = 4 for x = 1:  (1, 2) \\)\n" +
                    "\\(2^3 = 8, so log_2(8) = 3; x + 3 = 8 for x = 5:  (5, 3)\\)\n" +
                    "Then, working in the other direction: \n" +
                    "\\(2^{-1} = 0.5, so log_2(0.5) = -1;  \\)\n" +
                    "        \\(x + 3 = 0.5 for x = -2.5:   (-2.5, -1) \\)\n" +
                    "\\(2^{-2} = 0.25, so log2(0.25) = -2; \\)\n" +
                    "        \\(x + 3 = 0.25 for x = -2.75:   (-2.75, -2) \\)\n" +
                    "\\(2^{-3} = 0.125, so log2(0.125) = -3; \\)\n" +
                    "        \\(x + 3 = 0.125 for x = -2.875:   (-2.875, -3) \\)");
            textView_tabExample2_3.setText("Plotting the points we've calculated and connected them, we get:");
            imageView_tabExample2_3.setImageResource(R.drawable.logarit_fun3);
        }

/**---------------------------------*/
        else if(cardTitle.equals("Polynomial\n")){
            mathView_tabExample2_task.setText("Lets see when all three root are different: \\( x^3 - 6x^2 +11x -6 = 0\\)");
            textView_tabExample2_1.setText("This equation can be factorised to give");
            mathView_tabExample2_2.setText("\\((x-1)(x-2)(x-3)=0\\)");
            textView_tabExample2_3.setText("This equation has three real roots, all different - the solutions are x = 1, x = 2 and x = 3");
            mathView_tabExample2_4.setText("Lets see another example: \\(x^3+x^2+x-3 = 0\\)");
            textView_tabExample2_5.setText("This equation can be factorised to give");
            mathView_tabExample2_6.setText("\\((x-1)(x^2+2x+3) = 0\\)");
            textView_tabExample2_7.setText("The quadratic x^2 + 2x + 3 = 0 has no real solutions, so the only solution to the cubic equation is obtained by putting x − 1 = 0, giving the single real solution x = 1.\n");
        }
        else if(cardTitle.equals("Trigonometric equation")){
            mathView_tabExample2_task.setText("Simplify the expression: \\(\\frac{sin^2(x)-cos^2(x)+1}{cos^2(x)}\\)");
            textView_tabExample2_1.setText("First we will replace 1 with sin^2(x)+cos^2(x) using the first formula.Then we will subtract cos^2(x) and add sin^2(x). After that we will devide numerator and denominator with cos^2(x)");
            mathView_tabExample2_2.setText("\\(\\frac{sin^2(x)-cos^2(x)+1}{cos^2(x)}\\) = \\(\\frac{sin^2(x)-cos^2(x)+sin^2(x)+cos^2(x)}{cos^2(x)}\\) = \\(\\frac{2sin^2(x)}{cos^2(x)}\\) = \\(\\frac{2\\frac{sin^2(x)}{cos^2(x)}}{\\frac{cos^2(x)}{cos^2(x)}}\\)");
            textView_tabExample2_3.setText("After reduction we can exchange sin and cos with tg");
            mathView_tabExample2_4.setText("\\(2\\frac{sin^2(x)}{cos^2(x)}\\) = \\(2tg^2(x)\\)");
        }
        else if(cardTitle.equals("Exponential equation")){
            mathView_tabExample2_task.setText("Solve \\(3^x = 9\\)");
            mathView_tabExample2_2.setText("Since \\(9 = 3^2\\), you actually have to solve: \\(3^x = 3^2\\)");
            textView_tabExample2_3.setText("By converting the 9 to a 32, right-hand side of the equation has the same base as the left-hand side. Since the bases are now the same, we can set the two powers equal to each other: x = 2");
            mathView_tabExample2_4.setText("Solve \\( 3^{2x-1} = 27\\)");
            textView_tabExample2_5.setText("In this case, we have an exponential on one side of the \"equals\" and a number on the other. We can solve the equation if we can express the \"27\" as a power of 3. Since 27 = 3^3, then we can convert and proceed with the solution:");
            mathView_tabExample2_6.setText("\\(3^{2x-1} = 27\\) ==> \\(3^{2x-1} = 3^3\\) ==> \\(2x-1 = 3\\) ==> \\(2x = 4\\) ==> \\(x = 2\\)");
        }
        else if(cardTitle.equals("Logarithmic equation")){
            mathView_tabExample2_task.setText("Solve \\(log_b(x^2-30)= log_b(x)\\)");
            textView_tabExample2_1.setText("Since the logs have the same base, we can set the arguments equal and solve:");
            mathView_tabExample2_2.setText("\\(x^2-30 = x\\) ==> \\(x^2 - x - 30 = 0\\) ==> \\((x-6)(x+5)\\) ==> x = 6, -5");
            textView_tabExample2_3.setText("Since we cannot have a negative inside a logarithm, the quadratic-equation solution \"x = –5\" can not be a valid solution to the original logarithmic equation (in particular, this negative value won't work in the right-hand side of the original equation). Then solution is:");
            mathView_tabExample2_4.setText("\\(x = 6\\)");
        }
    }
}
