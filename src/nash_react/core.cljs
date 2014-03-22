(ns nash-react.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(set-print-fn! js/print)

(def app-state {:name "Sample" :email "sample@mail.com" :list ["one" "two" "three"]})

(defn some-view [data owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil
        (dom/p nil (:name data))
        (dom/p nil (:email data))
        (apply dom/ul nil
          (map #(dom/li nil %) (:list data)))))))

(println (dom/render-to-str (om/build some-view app-state)))

(dotimes [_ 10]
  (time
    (dotimes [_ 1000]
      (dom/render-to-str (om/build some-view app-state)))))
