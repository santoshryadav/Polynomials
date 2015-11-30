;;differentiate will calculate the derivative of a polynomial

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

;;poly function calculates derivative of single items and returns to differentiate

(defn poly [list2]
  (if-not (empty? list2)
    (if-not (= 0 (second list2))
      (vector (* (first list2) (second list2)) (- (second list2) 1))
    )
  )
)


(differentiate [[3 4] [4 5] [7 0]])