package com.abhinash.RedditcCone.repository;

import com.abhinash.RedditcCone.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
