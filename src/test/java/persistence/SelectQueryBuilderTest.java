package persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SelectQueryBuilderTest {

    @Test
    void test1() {
        // 예시 1: 기본 조회
        String sql = new SelectQueryBuilder()
                .select("id", "name", "age")
                .from("users")
                .build();
        // 결과: "SELECT id, name, age FROM users"
        assertThat(sql).isEqualTo("SELECT id, name, age FROM users");
    }

    @Test
    void test2() {

        // 예시 2: 정렬 추가
        String sql = new SelectQueryBuilder()
                .select("*")
                .from("users")
                .orderBy("age", "DESC")
                .build();
        // 결과: "SELECT * FROM users ORDER BY age DESC"

        assertThat(sql).isEqualTo("SELECT * FROM users ORDER BY age DESC");

    }

    @Test
    void test3() {
        // 예시 3: LIMIT 추가
        String sql = new SelectQueryBuilder()
                .select("id", "name")
                .from("users")
                .orderBy("id", "ASC")
                .limit(10)
                .build();

        assertThat(sql).isEqualTo("SELECT id, name FROM users ORDER BY id ASC LIMIT 10");
    }
}