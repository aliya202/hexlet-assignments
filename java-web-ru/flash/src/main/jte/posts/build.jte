@import java.lang.String
@param String flash
@param String flashType
@param String title
@param String content

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    @if(flash != null)
        <div class="alert alert-${flashType}" role="alert">
            ${flash}
        </div>
    @endif
    ${content}
</div>
</body>
</html>