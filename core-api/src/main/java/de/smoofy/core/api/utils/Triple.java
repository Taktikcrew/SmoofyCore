package de.smoofy.core.api.utils;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 23:27
 */

import lombok.experimental.Accessors;

import java.util.Objects;

@Accessors(fluent = true)
public record Triple<A, B, C>(A first, B second, C third) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triple<?, ?, ?> triple)) return false;
        return Objects.equals(this.first, triple.first) && Objects.equals(this.second, triple.second) && Objects.equals(this.third, triple.third);
    }
}
