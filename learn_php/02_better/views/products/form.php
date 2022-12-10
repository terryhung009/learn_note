<?php if (!empty($errors)) : ?>
    <div class="alert alert-danger">
        <?php foreach ($errors as $error) : ?>
            <div>
                <?php echo $error ?>
            </div>
        <?php endforeach; ?>
    </div>
<?php endif; ?>

<form action="" method="post" enctype="multipart/form-data">
    <?php if ($product['image']) : ?>
        <img src="/<?php echo $product['image'] ?>" alt="" class="update-image">

    <?php endif; ?>


    <div class="mb-3">
        <label class="form-label">Product Image</label>
        <input type="file" class="form-control" name="image">

    </div>
    <div class="mb-3">
        <label class="form-label">Product Title</label>
        <input type="text" class="form-control" name="title" value="<?php echo $title ?>">

    </div>
    <div class=" mb-3">
        <label class="form-label">Product Description</label>
        <textarea class="form-control" name="description"><?php echo $description ?></textarea>

    </div>
    <div class="mb-3">
        <label class="form-label">Product Price</label>
        <input type="number" step=".01" class="form-control" name="price" value="<?php echo $price ?>">

    </div>


    <button type="submit" class="btn btn-primary">Submit</button>
</form>