<nav id="ib_pag_nav">
	<ul class="pagination">
		<li><a href="${destPage}?page=1">&laquo;</a>
		</li>
		<!-- 分页 idx当前页 currPage-->
		<c:forEach var="idx" begin="${startPage}" end="${endPage}">
			<c:if test="${idx == currPage}">
				<li class="active"><a href="javascript:void(0)">${idx} <span class="sr-only">(当前页)</span>
				</a>
				</li>
			</c:if>
			<c:if test="${idx != currPage}">
				<li><a href="${destPage}?page=${idx}">${idx} </a>
				</li>
			</c:if>
		</c:forEach>
		<li><a href="${destPage}?page=${endPage}">&raquo;</a>
		</li>
	</ul>
</nav>