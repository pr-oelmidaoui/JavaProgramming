package ma.dentalPro.shared;

/**
 * Signale une erreur survenue dans la couche d'accès aux données.
 *
 * <p>Cette exception métier masque les détails JDBC aux couches service et
 * contrôleur tout en conservant l'exception technique originale comme cause.
 * Elle permet ainsi d'identifier clairement une erreur de repository sans
 * exposer directement {@link java.sql.SQLException}, et préserve la pile
 * d'exécution complète nécessaire au diagnostic.</p>
 *
 * <p>Elle hérite de {@link RuntimeException} afin que les interfaces des
 * repositories ne soient pas obligées de déclarer les exceptions techniques
 * avec {@code throws}.</p>
 */
public class RepositoryException extends RuntimeException {

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Retourne une description courte adaptée à l'affichage, sans imprimer
     * toute la pile d'exécution.
     *
     * @return le type de l'exception, le message métier et la cause technique
     */
    public String getSummary() {
        var causeMessage = getCause() == null
                ? "Cause technique non disponible"
                : getCause().getMessage();

        return "[%s] %s — Cause : %s".formatted(
                getClass().getSimpleName(),
                getMessage(),
                causeMessage
        );
    }
}
