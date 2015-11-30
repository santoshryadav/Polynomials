;;declaring variables

(def poly1 [[1 2] [2 1] [1 0]])
(def poly2 [[1 2] [-1 0]])
(def poly3 [[6 2] [1 1] [-1 0]])

;;poly-cal and sum function together will calculate the value of a polynomial for a value

(defn poly-cal [list]
  (fn [n]
    (if (empty? list)
      0
      (sum n list)
    )
  )
)

(defn sum [n list]

  (if (empty? list)
    0
   (+ (* (first (first list)) (java.lang.Math/pow n (second (first list)))) (sum n (rest list)))
  )
)

;;-----------------------------------------------------------------------


;;;;This will calculate the derivative of a polynomial

(defn differentiate [list1]
  (loop [counter 0 ans []]
    (if(>= counter (count list1))
      ans
      (if-not (= 0 (second (list1 counter)))
       (recur (inc counter) (conj ans (poly (list1 counter))))
        ans
      )
    )
  )
)

(defn poly [list2]
  (if-not (empty? list2)
    (if-not (= 0 (second list2))
      (vector (* (first list2) (second list2)) (- (second list2) 1))
    )
  )
)

(differentiate [[3 4] [4 5] [7 0]])

;;------------------------------------------------------------

;;These functions together calculate the root of polynomial

(defn root [delta list1 n]

  (loop [counter 1 ans [200 n]]
    (if(< (java.lang.Math/abs (- (ans counter) (ans (- counter 1)))) delta)
      ans
      (recur (inc counter) (conj ans (division list1 (ans counter))))
    )
  )
)

(defn division [list2 n2]
 (read-string (format "%.4f"  (- n2 (/ ((poly-cal list2) n2) ((poly-cal (differentiate list2)) n2)))))
)

;;User calls find-root function

(defn find-root [delt list2 n2]
  (last (root delt list2 n2))
)

;;;end of the find-rrot function

(find-root 0.0001 poly1 10)

(find-root 0.0001 poly2 10)

(find-root 0.0001 poly2 -10)

(find-root 0.0001 poly3 10)