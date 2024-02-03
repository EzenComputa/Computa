package com.computa.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.text.html.parser.Entity;
import javax.persistence.EntityManager;

import org.hibernate.sql.ast.tree.predicate.BooleanExpressionPredicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.computa.dto.UsedItemSearchDto;
import com.computa.entity.ItemSellStatus;
import com.computa.entity.UsedItem;
import com.computa.persistence.UsedItemRepositoryCustom;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UsedItemRepositoryCustomImpl implements UsedItemRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public UsedItemRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression serachSellSatatusEq(ItemSellStatus searchSellStatus) {
        return searchSellStatus == null ? null : QUseditem.usedItem.itemSellStatus.eq(searchSellStatus);
    }

    private BooleanExpressionPredicate regDtsAfter(String searchDateType) {
        LocalDateTime dateTime = LocalDateTime.now();

        switch (searchDateType) {
            case "1d":
                dateTime = dateTime.minusDays(1);
                break;
            case "1w":
                dateTime = dateTime.minusWeeks(1);
                break;
            case "1m":
                dateTime = dateTime.minusMonths(1);
                break;
            case "6m":
                dateTime = dateTime.minusMonths(6);
                break;
            default:
                return null;
        }

        return QUseditem.usedItem.regTime.after(dateTime);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery) {
        switch (searchBy) {
            case "usedItemNm":
                return QUseditem.useditem.usedItemNm.like("%" + searchQuery + "%");
                break;
            case "createBy":
                return QUseditem.useditem.createdBy.like("%" + searchQuery + "%");
                break;
            default:
                return null;
        }
    }

    @Override
    public Page<UsedItem> getUserUsedItemPage(UsedItemSearchDto usedItemSearchDto, Pageable pageable) {
        List<UsedItem> content = queryFactory
                .selectFrom(QUseditem.useditem)
                .where(regDtsAfter(usedItemSearchDto.getSearchDateType()),
                        serachSellSatatusEq(usedItemSearchDto.getSearchSellStatus()),
                        searchByLike(usedItemSearchDto.getSearchBy(),
                                usedItemSearchDto.getSearchQuery()))
                .orderBy(QUseditem.useditem.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long total = content.size();
        return new PageImpl<>(content, pageable, total);
    }
}
