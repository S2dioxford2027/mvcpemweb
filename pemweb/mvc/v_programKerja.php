<html>
<head></head>
<body>
<h2>Daftar Program Kerja BEM</h2>
<table border="1">
    <tr>
        <td>No</td>
        <td>Nama Program Kerja</td>
        <td>Surat Keterangan</td>
        <td>Aksi</td>
    </tr>
    <?php
    foreach ($proker as $row) {
        echo "<tr>";
        echo "<td>{$row['nomorProgram']}</td>";
        echo "<td>{$row['namaProgram']}</td>";
        echo "<td>{$row['suratKeterangan']}</td>";
        echo "<td>
                <a href='?action=update&nomorProgram={$row['nomorProgram']}'>Update</a> |
                <a href='?action=delete&nomorProgram={$row['nomorProgram']}'>Delete</a>
              </td>";
        echo "</tr>";
    }
    ?>
</table>

<h3>Tambah Program Kerja Baru</h3>
<form method="POST" action="?action=create">
    <input type="text" name="namaProgram" placeholder="Nama Program Kerja" required>
    <input type="text" name="suratKeterangan" placeholder="Surat Keterangan" required>
    <input type="submit" value="Tambah Program">
</form>

<?php if (isset($_GET['action']) && $_GET['action'] == 'update' && isset($_GET['nomorProgram'])): ?>
    <h3>Update Program Kerja</h3>
    <form method="POST">
        <input type="text" name="namaProgram" value="<?php echo isset($programToUpdate) ? $programToUpdate['namaProgram'] : ''; ?>" placeholder="Nama Program Kerja" required>
        <input type="text" name="suratKeterangan" value="<?php echo isset($programToUpdate) ? $programToUpdate['suratKeterangan'] : ''; ?>" placeholder="Surat Keterangan" required>
        <input type="submit" value="Update">
    </form>
<?php endif; ?>
</body>
</html>
