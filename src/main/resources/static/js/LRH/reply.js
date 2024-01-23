var comments = [];
var commentId = 1;

function addComment() {
    var commentText = document.getElementById('comment').value;

    if (commentText.trim() === '') {
        alert('댓글을 입력하세요.');
        return;
    }

    var newComment = {
        id: commentId,
        text: commentText,
        replies: []
    };

    comments.push(newComment);
    displayComments();
    commentId++;

    // 댓글 등록 후 입력 필드 초기화
    document.getElementById('comment').value = '';
}

function addReply(parentId) {
    var replyText = prompt('대댓글 작성:');
    if (!replyText) return;

    var parentComment = findCommentById(parentId);
    if (parentComment) {
        var newReply = {
            id: commentId,
            text: replyText
        };
        parentComment.replies.push(newReply);
        displayComments();
        commentId++;
    }
}

function deleteComment(commentId) {
    comments = comments.filter(function(comment) {
        return comment.id !== commentId;
    });

    displayComments();
}

function deleteReply(commentId, replyId) {
    var parentComment = findCommentById(commentId);
    if (parentComment) {
        parentComment.replies = parentComment.replies.filter(function(reply) {
            return reply.id !== replyId;
        });
        displayComments();
    }
}

function findCommentById(commentId) {
    return comments.find(function(comment) {
        return comment.id === commentId;
    });
}

function displayComments() {
    var commentsContainer = document.getElementById('comments-container');
    commentsContainer.innerHTML = '';

    comments.forEach(function(comment) {
        var commentElement = document.createElement('div');
        commentElement.classList.add('comment');
        commentElement.innerHTML = '<p>' + comment.text + '</p>';

        if (comment.replies.length > 0) {
            commentElement.innerHTML += '<div class="replies">';
            comment.replies.forEach(function(reply) {
                var replyElement = document.createElement('p');
                replyElement.classList.add('reply');
                replyElement.innerHTML = reply.text + ' <button onclick="deleteReply(' + comment.id + ', ' + reply.id + ')">삭제</button>';
                commentElement.appendChild(replyElement);
            });
            commentElement.innerHTML += '</div>';
        }

        // 버튼 그룹 추가
        var buttonGroup = document.createElement('div');
        buttonGroup.classList.add('button-group');
        buttonGroup.innerHTML += '<button onclick="deleteComment(' + comment.id + ')">삭제</button>';
        buttonGroup.innerHTML += '<button onclick="addReply(' + comment.id + ')">대댓글 작성</button>';
        commentElement.appendChild(buttonGroup);

        commentsContainer.appendChild(commentElement);
    });
}
