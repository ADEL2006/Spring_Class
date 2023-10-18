package org.zerock.guestbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.guestbook.entity.MemoEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

    @Query("SELECT m.mno, m.memoText " +
            "FROM MemoEntity m")
    List<Object[]> getList();

    @Query(
            value = "SELECT m FROM MemoEntity m WHERE m.mno>:mno",
            countQuery = "SELECT COUNT(m) FROM MemoEntity m WHERE m.mno>:mno")
    Page<MemoEntity> getListWithQuery(@Param("mno") Long mno, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE MemoEntity m " +
            "SET m.memoText=:memoText " +
            "WHERE m.mno=:mno")
    int updateMemoText(
            @Param("mno") Long mno,
            @Param("memoText") String memoText
            );

    @Query("SELECT m " +
            "FROM MemoEntity m " +
            "WHERE m.mno= :mno") // JPQL
        Optional<MemoEntity> findByMno(Long mno);


//  where mno = ?
//    Optional<MemoEntity> findByMno(Long mno);

    List<MemoEntity> findByMnoBetweenOrderByMnoDesc(Long from, Long to);


//    List<MemoEntity> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

//    Optional<MemoEntity> findByMno(Long mno);

//    @Query("SELECT m FROM MemoEntity m WHERE m.mno = :mno")
//    Optional<MemoEntity> findByMno(@Param("mno") Long mno);

//    @Transactional
//    @Modifying
//    @Query("UPDATE MemoEntity m SET m.memoText = :memoText WHERE m.mno = :mno")
//    int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText);



}
