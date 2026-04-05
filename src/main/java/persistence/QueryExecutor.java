package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class QueryExecutor {
    private final Connection connection;
    private final ResultSetMapper mapper;

    public QueryExecutor(Connection connection) {
        this.connection = connection;
        this.mapper = new ResultSetMapper();
    }

    /**
     * SELECT 쿼리 실행 및 자동 매핑
     */
    public <T> List<T> query(String sql, Class<T> resultClass, Object... params)
            throws SQLException {
        return null;
    };

    /**
     * Named Parameter 쿼리 실행
     */
    public <T> List<T> query(NamedParameterQuery query, Class<T> resultClass)
            throws SQLException {
        return null;
    };

    /**
     * INSERT/UPDATE/DELETE 실행
     */
    public int execute(String sql, Object... params) throws SQLException {
        return 1;
    };

    /**
     * Named Parameter로 실행
     */
    public int execute(NamedParameterQuery query) throws SQLException {
        return 1;
    };
}
