package com.example.demogridflow.entity;

import java.util.Arrays;
import java.util.List;

public enum  Service {
    ADVERT{
        @Override
        public String toString() {
            return "Реклама";
        }
    },
    ADVERTSING{
        @Override
        public String toString() {
            return "Объявление";
        }
    },
    PUBLICITION{
        @Override
        public String toString() {
            return "Публикация";
        }
    }


}
