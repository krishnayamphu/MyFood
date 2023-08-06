<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="#">MyFood</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/myfood/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/myfood/about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/myfood/contact">Contact</a>
                    </li>
                </ul>
                <c:choose>
                    <c:when test="${user==null}">
                        <a class="btn btn-secondary" href="/myfood/login">
                            Sign in
                        </a>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-group">

                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" data-bs-auto-close="true" aria-expanded="false">
                                    ${user}
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/myfood/my-orders">My Orders</a></li>
                                <li><a class="dropdown-item" href="/myfood/profile">Profile</a></li>
                                <li><a class="dropdown-item" href="#">
                                    <form action="/myfood/logout" method="post">
                                        <button>Logout</button>
                                    </form>
                                </a></li>
                            </ul>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
</header>