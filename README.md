# Polynomials
The directory has source code for generating Polynomials in Clojure, calculating their derivatives and finding the roots.

#Generating Polynomials and Calculating Values
We can represent a polynomial of one variable as a vector of vectors. For example x2 + 3*x - 1
can be represented by [[1 2] [3 1] [-1 0]]. Here the first element of the inner vector is the coeffi-
cient and the second element is the exponent of variable.  
  
  
Clojure function, make-poly, with one argument, a polynomial in the form given  
above. The function returns a function, call it polynomial. This polynomial function accepts  
one argument, a number, and returns the value of the polynomial evaluated on the input.  
So we will get:    
(def example (poly-maker [[1 2] [3 1] [-1 0]]))  
(example 2) will return 9.0  
(map example [0 1 2 3 4 5]) will return (-1.0 3.0 9.0 17.0 27.0 39.0)  

#Calculating Derivatives
 Function (differentiate) that has one argument, a polynomial in the above format. The
function returns the derivative of the polynomial. So  
(differentiate [[1 2] [3 1] [-1 0]]) returns [[2 1] [3 0]]  
(differentiate [[3 4] [5 2] [6 1]]) returns [[12 3] [10 1] [6 0]]  

#Deriving Roots of Polynomial
Given a polynomial, call it p(x), we want to find a value of x where p(x) = 0. That is x is a  
root of the polynomial. Let p’(x) be the derivative of p(x). Select a value x0 and let x1 = x0 -  
p(x0)/p’(x0), x2 = x1 - p(x1)/p’(x1), ... , xn - p(xn-1)/p’(xn-1). In most cases x0, x1, x2, x3, ... xn  
converges to a root of the polynomial. So to find a root of the polynomial compute x0, x1,  
x2, x3, ... xn until | xn - xn-1 | is small. Then xn is a good approximate of a root of the polynomial.  
Clojure function find-root has three arguments. The first is float that is how  
small we want | xn - xn-1 | to be. The second is polynomial vector that we want to find the  
root of. The third argument is a guess for x0. The function find-root return xn. For example  
(def poly1 [[1 2] [2 1] [1 0]])!! ;(x+1)(x+1) so root = -1  
(def poly2 [[1 2] [-1 0]])! ! ;(x+1)(x-1) so roots are 1, -1  
(def poly3 [[6 2] [1 1] [-1 0]]) ;(2x+1)(3x-1) so roots are -1/2 and 1/3  
(find-root 0.0001 poly1 10) returns -0.999832  
(find-root 0.0001 poly2 10) returns 1.000005  
(find-root 0.0001 poly2 -10) returns -1.000005  
(find-root 0.0001 poly3 10) returns 0.3333333  
