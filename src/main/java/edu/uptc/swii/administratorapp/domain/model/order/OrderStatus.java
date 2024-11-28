package edu.uptc.swii.administratorapp.domain.model.order;

import java.util.Set;
import java.util.EnumSet;

public enum OrderStatus {
    RECEIVED {
        @Override
        public Set<OrderStatus> allowedTransitions() {
            return EnumSet.of(IN_PROGRESS);
        }
    },
    IN_PROGRESS {
        @Override
        public Set<OrderStatus> allowedTransitions() {
            return EnumSet.of(SENDED);
        }
    },
    SENDED {
        @Override
        public Set<OrderStatus> allowedTransitions() {
            return EnumSet.noneOf(OrderStatus.class);
        }
    };

    public abstract Set<OrderStatus> allowedTransitions();

    public boolean canTransitionTo(OrderStatus newStatus) {
        return allowedTransitions().contains(newStatus);
    }
}