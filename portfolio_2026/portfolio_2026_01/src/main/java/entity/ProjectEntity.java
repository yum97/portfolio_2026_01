package entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "member_count")
    private Integer memberCount;

    @Column(name = "period", columnDefinition = "TEXT")
    private String period;

    @Column(name = "details", columnDefinition = "TEXT", nullable = false)
    private String details;

    @Column(name = "github_url", length = 255)
    private String githubUrl;

    @Column(name = "is_visible", nullable = false)
    private Boolean isVisible = true;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectImageEntity> images;

}