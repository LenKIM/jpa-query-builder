package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NamedParameterQuery {

    /**
     * Named Parameter를 지원하는 쿼리 생성
     * @param sql Named Parameter가 포함된 SQL (:paramName 형식)
     */
    public NamedParameterQuery(String sql) {
//        sql
    };

    /**
     * 파라미터 값 설정
     * @param name 파라미터 이름
     * @param value 파라미터 값
     */
    public NamedParameterQuery setParameter(String name, Object value) {
        return null;
    };

    /**
     * JDBC용 SQL로 변환 (? 플레이스홀더)
     * @return 변환된 SQL
     */
    public String toJdbcSql() {
        return null;
    };

    /**
     * PreparedStatement에 파라미터 바인딩
     * @param pstmt PreparedStatement
     */
    public void bindParameters(PreparedStatement pstmt) throws SQLException {

    };
}
