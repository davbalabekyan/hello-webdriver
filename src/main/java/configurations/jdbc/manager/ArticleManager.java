package configurations.jdbc.manager;

import configurations.jdbc.conf.DBConnectionProvider;
import configurations.jdbc.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleManager implements Manager<Article, Integer> {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
        try {
            String query = "SELECT * FROM wikipedia_articles";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setName(resultSet.getString("name"));
                article.setHref(resultSet.getString("href"));
                articles.add(article);
            }
        } catch (SQLException E) {
            throw new RuntimeException("Oops, something went wrong during getAll");
        }
        return articles;
    }

    @Override
    public Article getById(Integer id) {
        Article article = new Article();
        try {
            String query = "SELECT * FROM wikipedia_articles WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                article.setId(resultSet.getInt("id"));
                article.setName(resultSet.getString("name"));
                article.setHref(resultSet.getString("href"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during getById");
        }
        return article;
    }

    @Override
    public void create(Article object) {
        try {
            String query = "INSERT INTO wikipedia_articles(name,href) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getHref());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during create");
        }
    }

    @Override
    public void update(Article article) {
        try {
            String query = "UPDATE wikipedia_articles SET name=?,href=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, article.getName());
            statement.setString(2, article.getHref());
            statement.setInt(3, article.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during update");
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String query = "DELETE FROM wikipedia_articles WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong during delete");
        }
    }
}
