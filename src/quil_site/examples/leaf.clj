(ns quil-site.examples.leaf
  (:require [quil.core :as q :include-macros true]
            ))

;;;
;;; Example from Quil Intro blogpost
;;; http://nbeloglazov.com/2014/05/29/quil-intro.html
;;;

(defn leaf-fn [t]
  (let [r (* 1.6 t (q/cos t) (q/sin t))]
    [(* r (q/sin (* 1.1 t)))
     (* r (q/tan t))]))

(defn setup []
  (q/frame-rate 60)
  (q/background 255))

(defn draw []
  (q/with-translation [(/ (q/width) 2) 0]
                      (let [t (/ (q/frame-count) 10)]
                        (q/line (leaf-fn t) (leaf-fn (+ t 0.1))))))

(q/defsketch leaf
             :host "host"
             :size [500 500]
             :setup setup
             :draw draw)