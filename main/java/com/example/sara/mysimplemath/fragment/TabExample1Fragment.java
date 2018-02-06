package com.example.sara.mysimplemath.fragment;

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
 * Example tab
 *
 * It is part of TabLessonActivity
 */
public class TabExample1Fragment extends Fragment {
    String cardTitle;
    public MathView mathView_tabExample_task;
    public TextView textView_tabExample_1;
    public TextView textView_tabExample_2;
    public MathView mathView_tabExample_3;
    public MathView mathView_tabExample_4;
    public TextView textView_tabExample_5;
    public MathView mathView_tabExample_6;
    public MathView mathView_tabExample_7;
    public MathView mathView_tabExample_8;
    ImageView imageView_tabExample1_1;
    ImageView imageView_tabExample1_2;
    ImageView imageView_tabExample1_3;
    ImageView imageView_tabExample1_4;
    TextView textView_tabExample1_6i7;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab_example1, container, false);
        cardTitle = ((TabLessonActivity)getActivity()).getCardTitle();

        mathView_tabExample_task = (MathView) layout.findViewById(R.id.textView_tabExample_task);
        textView_tabExample_1 = (TextView) layout.findViewById(R.id.textView_tabExample_1);
        textView_tabExample_2 = (TextView) layout.findViewById(R.id.textView_tabExample_2);
        mathView_tabExample_3 = (MathView) layout.findViewById(R.id.textView_tabExample_3);
        mathView_tabExample_4 = (MathView) layout.findViewById(R.id.textView_tabExample_4);
        textView_tabExample_5 = (TextView) layout.findViewById(R.id.textView_tabExample_5);
        mathView_tabExample_6 = (MathView) layout.findViewById(R.id.mathView_tabExample_6);
        mathView_tabExample_7 =(MathView) layout.findViewById(R.id.mathView_tabExample_7);
        mathView_tabExample_8 = (MathView) layout.findViewById(R.id.mathView_tabExample_8);
        imageView_tabExample1_1 = (ImageView) layout.findViewById(R.id.imageView_tabExample1_1);
        imageView_tabExample1_2 = (ImageView) layout.findViewById(R.id.imageView_tabExample1_2);
        imageView_tabExample1_3 = (ImageView) layout.findViewById(R.id.imageView_tabExample1_3);
        imageView_tabExample1_4 = (ImageView) layout.findViewById(R.id.imageView_tabExample1_4);
        textView_tabExample1_6i7 = (TextView) layout.findViewById(R.id.textView_tabExample_6i7);

        setData();
        return layout;
    }

    private void setData() {
        if(cardTitle.equals("Derivative rules \n")){
            mathView_tabExample_task.setText("Derivate: \\((x^2+x^3)'\\) and \\((cos(x)*sin(x))'\\)");
            textView_tabExample_2.setText("For the first one we will use sum rule:");
            mathView_tabExample_3.setText("\\((x^2+x^3)' = 2*x+3*x^2\\)");
            textView_tabExample_5.setText("For the second one we will use product rule:");
            mathView_tabExample_6.setText("\\((cos(x)*sin(x))'= cos(x)*cos(x) - sin(x)*sin(x) = cos(x)^2 - sin(x)^2\\)");

        }
        else if(cardTitle.equals("Derivatives \napplications")){
            mathView_tabExample_task.setText("Well done!");
            textView_tabExample_2.setText("Since this chapter is theoretical, there wan't be examples. If you want to learn more about derivations applications move to the next tab.");
        }
        else if(cardTitle.equals("Derivatives of elementary \nfunctions")){
            mathView_tabExample_task.setText("Here will be demonstrated how to derivate some elementary functions.");
            textView_tabExample_2.setText("Here are some examples:");
            mathView_tabExample_3.setText("\\((x^2)' = 2*x^(2-1)=2*x\\)");
            mathView_tabExample_4.setText("\\((\\frac{1}{x^7})'= \\frac{-7}{x^(7+1)}=\\frac{-7}{x^(8)}\\)");

            textView_tabExample_5.setText("Here are some more complicated examples:");
            mathView_tabExample_8.setText("\\((sin(x)^2)' = 2*sin(x)*sin(x)' = 2*sin(x)*cos(x) = sin(2x)\\)");
            mathView_tabExample_6.setText("\\((tg(x)^2 + ctg(x))' = 2*tg(x)*tg(x)' + \\frac{1}{sin(x)^2} = 2*sin(x)*\\frac{1}{cos(x)^2} + \\frac{1}{sin(x)^2}\\)");
        }
        else if(cardTitle.equals("Determining local extremes \n")){
            mathView_tabExample_task.setText("Find local extremes  with the first derivative test: \\(f(x)=3*x^5 - 20*x^3\\)");
            textView_tabExample_1.setText("Find the first derivative of f using the power rule.");
            mathView_tabExample_3.setText("\\(f(x)=3*x^5 - 20*x^3 => f'(x)=15*x^4-60*x^2\\)");
            mathView_tabExample_4.setText("Set the derivative equal to zero and solve for x. \\(15*x^4-60*x^2 = 0\\) \n \\(15*x^2(x^2-4)= 0\\) \n \\(15*x^2(x-2)(x+2)= 0\\)");
            textView_tabExample_5.setText("x1= 0, x2 = -2 , x3 = 2 \nThese three x-values are the critical numbers of f.");
            mathView_tabExample_6.setText("Take a number line and put down the critical numbers you have found: 0, –2, and 2. \n You divide this number line into four regions: to the left of –2, from –2 to 0, from 0 to 2, and to the right of 2.");
            mathView_tabExample_8.setText("Pick a value from each region, plug it into the first derivative, and note whether your result is positive or negative.\n" +
                    "For this example, you can use the numbers –3, –1, 1, and 3 to test the regions. \\(f'(-3)= 15*(-3)^4 -60(-3)^2 = 675\\) \\(f'(-1)= 15*(-1)^4 -60(-1)^2 = -45\\) \\(f'(1)= 15*(1)^4 -60(1)^2 = -45\\) \\(f'(3)= 15*(3)^4 -60(3)^2 = 675\\) Take your number line, mark each region with the appropriate positive or negative sign, and indicate where the function is increasing and decreasing. Obtain the function values (in other words, the heights) of these two local extrema by plugging the x-values into the original function. \\(f(-2)= 3(-2)^5 -20(-2)^3 = 64\\) \\(f(2)= 3(2)^5 -20(2)^3 = -64\\) Thus, the local max is located at (–2, 64), and the local min is at (2, –64). You’re done.");
        }

/**-----------------------*/
        else if(cardTitle.equals("The concept of integrals ")){
            mathView_tabExample_task.setText("Well done!");
            textView_tabExample_2.setText("Since this chapter is theoretical, there wan't be examples. If you want to learn more about concept of integrals move to the next tab.");
        }
        else if(cardTitle.equals("Substitution method")){
            mathView_tabExample_task.setText("Evaluate \\(\\displaystyle\\int(2x+3)^4\\)dx");
            textView_tabExample_1.setText("Step 1: Choose a substitution function u\nThe substitution function is u=2x+3");
            textView_tabExample_2.setText("Step 2: Determine the value dx \n 2x+3=u \n(2x+3)'dx = du \n 2dx = du \n dx = 1/2 du");
            mathView_tabExample_3.setText("Step 3: Make the substitution \\(\\displaystyle\\int(2x+3)^4dx = \\displaystyle\\int u^4 \\frac{1}{2}du\\)");
            mathView_tabExample_4.setText("Step 4: Integrate resulting integral \n  \\(\\displaystyle\\int(2x+3)^4dx = \\displaystyle\\int u^4 \\frac{1}{2}du = \\) \\( \\frac{1}{2} \\displaystyle\\int u^4 du \\)= \\( \\frac{1}{2} \\frac{u^{4+1}}{(4+1)}+C \\) = \\( \\frac{u^5}{10} + C \\)");
            textView_tabExample_5.setText("Step 5: Return to the initial variable: x");
            mathView_tabExample_6.setText("\\(\\frac{u^5}{10} + C = \\frac{(2x+3)^5}{10} + C \\)");
        }
        else if(cardTitle.equals("Partial Integration")){
            mathView_tabExample_task.setText("Evaluate the following integral   \\(\\displaystyle\\int x*sin(x)dx\\)");
            textView_tabExample_1.setText("Step 1: In this example we choose u = x and dv will be everything else that remains.\n  u=x   dv=sin(x)dx");
            textView_tabExample_2.setText("Step 2: Compute du and v\n  u=x           dv=sin(x)dx\n  du=x'dx    v=∫sin(x)dx \n  du=dx       v=-cos(x) \n\nStep 3: Use the formula.  \n   ∫x•sin(x)dx= x•(-cos(x)) - ∫(-cos(x))dx \n\nTherefore: \n   ∫x•sin(x)dx=\n   x•(-cos(x)) - ∫(-cos(x))dx =\n   -x•cos(x)+∫cos(x)dx =\n   -x•cos(x)+sin(x)+C");

        }
        else if(cardTitle.equals("Definite integrals")){
            mathView_tabExample_task.setText("Evaluate \\(\\displaystyle\\int^1_0\\! \\frac{x}{\\sqrt{x+1}}\\)dx");
            textView_tabExample_1.setText("Step 1: Choose a new variable u");
            mathView_tabExample_7.setText("\\(u = \\sqrt{x+1}\\)");
            mathView_tabExample_3.setText("Step 2: Calculate the reverse relation x through u: \\(u^2 = x+1 , u^2-1 = x\\)");
            mathView_tabExample_4.setText("Step 3: Determine the value dx : dx = 2u du");
            textView_tabExample_5.setText("Step 4: Determine new limits based od relation between x and u :");
            mathView_tabExample_6.setText("\\( x=0 \\Longrightarrow u=1, x=1 \\Longrightarrow u=\\sqrt{2}\\)");
            mathView_tabExample_8.setText("Step 5: Make the substitution and calculate integral:  \\(\\displaystyle\\int^1_0\\! \\frac{x}{\\sqrt{x+1}}dx = \\displaystyle\\int^{\\sqrt{2}}_{1}\\! \\frac{u^2-1}{u}2udu = 2\\displaystyle\\int^{\\sqrt{2}}_{1}\\! (u^2-1)du = 2(\\frac{u^3}{3}-u)|^{\\sqrt{2}}_{1} = \\frac{2}{3}(2-\\sqrt{2})\\)");
        }
/**-----------------------*/
        else if(cardTitle.equals("Polynomial")){
            mathView_tabExample_task.setText("Graph \\(f(x) = 5x^2+6x+1\\)");
            textView_tabExample_1.setText("In chapter one (derivations -> polinomial) we already solved the equation of this function.\n \nThe solutions are x1= -0.2 and x2= -1. \n\nThe graph of this function is: ");
            imageView_tabExample1_1.setImageResource(R.drawable.polinomial_f1);

            mathView_tabExample_4.setText("Graph \\(f(x) = 5x^2+2x+1\\)");
            textView_tabExample_5.setText("In chapter one (derivations -> polinomial) we already solved the equation of this function.\n \nThe solutions are complex so there are no real roots. \n\nThe graph of this function is: ");
            imageView_tabExample1_4.setImageResource(R.drawable.polinomial_f2);

        }
        else if(cardTitle.equals("Trigonometric function")){
            mathView_tabExample_task.setText("Graph one period of f(x) = –cos(3x)");
            textView_tabExample_1.setText("The \"minus\" sign tells us that the graph is upside down. Since the multiplier out front is an \"understood\" –1, the amplitude is unchanged. The argument (the 3x inside the cosine) is growing three times as fast as usual, because of the 3 multiplied on the variable, so the period is one-third as long. The period for this graph will be (2/3)π.\n\n Because we need upside down graph, we will first swap +1 and –1 points on the regular graph:");
            imageView_tabExample1_1.setImageResource(R.drawable.trigonom_fun1);
            textView_tabExample_2.setText("...and then we'll fill in the rest of the graph. (The original, \"regular\", graph is shown in gray below; my new, flipped, graph is shown in blue.)");
            imageView_tabExample1_2.setImageResource(R.drawable.trigonom_fun2);
            mathView_tabExample_4.setText("Okay, that takes care of the amplitude. Now we need to change the period.");
            textView_tabExample_5.setText("Rather than trying to figure out the points for the graph on the regular axis, we'll instead re-number the axis, which is a lot easier. The regular period is from 0 to 2π, but this graph's period goes from 0 to (2π)/3. Then the midpoint of the period is going to be (1/2)(2π)/3 = π/3, and the zeroes will be midway between the peaks (the high points) and the troughs (the low points). So we'll erase the x-axis values from the regular graph, and re-number the axis. Notice how we changed the axis instead of the graph. ");
            imageView_tabExample1_3.setImageResource(R.drawable.trigonom_fun3);
        }
        else if(cardTitle.equals("Exponential function")){
            mathView_tabExample_task.setText("Graph \\(y = 2^x + 4\\)");
            textView_tabExample_1.setText("This is the standard exponential, except that the \"+ 4\" pushes the graph up so it is four units higher than usual.\n\nFirst we compute some points:");
            imageView_tabExample1_1.setImageResource(R.drawable.exponent_fun1);
            textView_tabExample_2.setText("Then we plot those points:");
            imageView_tabExample1_2.setImageResource(R.drawable.exponent_fun2);
            textView_tabExample_5.setText("When x is negative, y = 2x + 4 won't be very close to zero; instead, it will be very close to 4, because the values will be \"a teensy-tiny little number, plus four\", which works out to be a teensy-tiny bit more than four. \n \nTo help me with my graph, and to indicate that I know that y = 2x + 4 never goes below (or even touches, for that matter) the line y = 4, I will drawn a dashed line at y = 4:");
            imageView_tabExample1_3.setImageResource(R.drawable.exponent_fun3);
            textView_tabExample1_6i7.setText("This dashed-in line, indicating where the graph goes as x heads off to the side, is called a \"horizontal asymptote\", or just an \"asymptote\". It is not required that you draw it in, but it can be helpful, and can point out to your teacher on the test that you do know what you're doing.\n\n Then the final result is:");
            imageView_tabExample1_4.setImageResource(R.drawable.exponent_fun4);
        }
        else if(cardTitle.equals("Logarithmic function")){
            mathView_tabExample_task.setText("Graph \\(y = log_3(x) + 2\\)");
            textView_tabExample_1.setText("This is the basic log graph, but it's been shifted upward by two units. To find plot points for this graph, we will plug in useful values of x (being powers of 3, because of the base of the log) and then we'll simplify for the corresponding values of y.");
            mathView_tabExample_3.setText("\\(3^0 = 1, so log_3(1) = 0\\), and \\(log_3(1) + 2 = 2 \\)\n" +
                    "\\(3^1 = 3, so log_3(3) = 1\\), and \\(log_3(3) + 2 = 3\\) \n" +
                    "\\(3^2 = 9, so log_3(9) = 2\\), and \\(log_3(9) + 2 = 4\\) \n" +
                    "\\(3^3 = 27, so log_3(27) = 3\\), and \\(log_3(27) + 2 = 5\\)");
            mathView_tabExample_4.setText("Moving in the other direction (to get some y-values for x between 0 and 1):");
            mathView_tabExample_6.setText("\\( 3^{ -1} = \\frac{1}{3} \\), so \\( log_3( \\frac{1}{3} ) =  -1 \\), and \\( log_3( \\frac{1}{3} ) + 2 = 1 \\)\n" +
                    "\\( 3^{ -2} = 1/9\\), so \\(log_3( 1/9 ) =  -2 \\), and \\( log_3( 1/9 ) + 2 = 0 \\)\n" +
                    "\\( 3^{ -3} = 1/27\\), so \\(log_3( 1/27 ) =  -3 \\), and \\( log_3( 1/27 ) + 2 =  -1 \\)");
            textView_tabExample1_6i7.setText("These are the only \"neat\" points that I'm going to bother finding for my graph. If we feel a need for additional plot points, especially between any two of the points we found above, we can evaluate the function \"ln(x) / ln(3)\" in my calculator.\n\nThe graph looks like this:");
            imageView_tabExample1_4.setImageResource(R.drawable.logarit_fun1);
        }

/**-----------------------*/
        else if(cardTitle.equals("Polynomial\n")){
            mathView_tabExample_task.setText("Solve: \\(5x^2+6x+1 = 0\\)");
            textView_tabExample_1.setText("We will use quadratic formula:");
            mathView_tabExample_7.setText("\\( x = \\frac{-b \\pm\\sqrt{b^2-4ac}}{2a}\\)");
            mathView_tabExample_3.setText("\\( x = \\frac{-6 \\pm\\sqrt{6^2-4*5*1}}{2*5}\\)  \\( x = \\frac{-6 \\pm\\sqrt{36-20}}{10}\\)  \\( x = \\frac{-6 \\pm\\sqrt{16}}{10}\\) \\( x = \\frac{-6 \\pm 4}{10}\\) The answers are: x1= -0.2 and x2= -1 ");
            mathView_tabExample_6.setText("Solve:  \\(5x^2+2x+1 = 0\\)");
            mathView_tabExample_8.setText("\\( x = \\frac{-2 \\pm\\sqrt{2^2-4*5*1}}{2*5}\\) \\( x = \\frac{-2 \\pm\\sqrt{2^2-20}}{10}\\)  \\( x = \\frac{-2 \\pm\\sqrt{-16}}{10}\\) The square root of -16 is 4i, so: \\( x = \\frac{-2 \\pm 4i}{10}\\)  The answer is: \\( x = -0.2 \\pm 0.4i\\)");
        }
        else if(cardTitle.equals("Trigonometric equation")){
            mathView_tabExample_task.setText("Solve: \\(cos(x)= \\frac{-\\sqrt{3}}{2}\\)");
            textView_tabExample_1.setText("First we will draw unit circle and mark on circle where x-coordinate is -sqrt(3)/2 (the cosine is at x coordinates and the sinus is at y coordinates)");
            mathView_tabExample_3.setText("Now we will read the answers to our equation in radians. For cosine we need to read the value above and below the x axis because those values share the same x coordinate. The answer is \\(\\frac{5\\pi}{6}\\) and \\(\\frac{7\\pi}{6}\\)");
            mathView_tabExample_4.setText("Solve: \\(sin(x)= \\frac{-1}{2}\\)");
            textView_tabExample_5.setText("First we will draw unit circle and mark on circle where y-coordinate is -1/2");
            mathView_tabExample_6.setText("Now we will read the answers to our equation in radians. For sinus we need to read the value left and right from y axis because those values share the same y coordinate. The answer is \\(\\frac{7\\pi}{6}\\) and \\(\\frac{11\\pi}{6}\\)");
        }
        else if(cardTitle.equals("Exponential equation")){
            mathView_tabExample_task.setText("Simple example: Solve \\(5^x = 5^3\\)");
            textView_tabExample_1.setText("Since the bases (\"5\" in each case) are the same, then the only way the two expressions could be equal is for the powers also to be the same. That is: x = 3");
            textView_tabExample_2.setText("This solution demonstrates the logical basis for how this entire class of equation is solved: If the bases are the same, then the powers must also be equal; this is the only way for the two sides of the equation to be equal to each other. Since the powers must be the same, then we can set the two powers equal to each other, and solve the resulting equation.");
            mathView_tabExample_3.setText("Solve \\(10^{1-x} = 10^4\\)");
            mathView_tabExample_4.setText("Since the bases are the same, then I can equate the powers and solve:");
            textView_tabExample_5.setText("1-x = 4 \n1-4 = x \n-3=x \n Then solution is: x = -3");
        }
        else if(cardTitle.equals("Logarithmic equation")){
            mathView_tabExample_task.setText("Simple example: Solve \\(log_2(x) = log_2(14)\\)");
            textView_tabExample_1.setText("The logarithms on either side of the equation have the same base;namely, a base of 2. The only way these two log expressions can be equal is for their arguments to be equal. In other words, the log expressions being equal says that the arguments must be equal, so we can create the following equation:\nx = 14\nThat is also solution to this equation.");

            mathView_tabExample_4.setText("Solve \\(log_b(x^2) = log_b(2x-1)\\) ");
            textView_tabExample_5.setText("The base of these logarithmic terms is unknown, being indicated by the letter b. But that's okay. We only need them bases to be the same. What those bases actually are doesn't matter for this sort of equation. Because the bases of the logs are the same, then we know that the insides of the logs must be equal. We'll use this to create our equation:");
            mathView_tabExample_6.setText("\\(x^2 = 2x-1\\) Then we can solve the log equation by solving this quadratic equation:");
            mathView_tabExample_8.setText("\\(x^2 - 2x + 1 = 0\\)  ==> \\((x-1)(x-1)= 0\\) Then the solution is: x = 1");
        }
    }}
