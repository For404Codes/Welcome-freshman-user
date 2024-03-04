<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="学院名" prop="name">
      <el-input v-model="dataForm.name" placeholder="学院名"></el-input>
    </el-form-item>
    <el-form-item label="学院简介" prop="introduction">
      <el-input v-model="dataForm.introduction" placeholder="学院简介"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建者用户ID" prop="createdUser">
      <el-input v-model="dataForm.createdUser" placeholder="创建者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="更新者用户ID" prop="updatedUser">
      <el-input v-model="dataForm.updatedUser" placeholder="更新者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="是否删除（1是，0否）" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除（1是，0否）"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          collegeId: 0,
          name: '',
          introduction: '',
          createTime: '',
          createdUser: '',
          updateTime: '',
          updatedUser: '',
          isDelete: ''
        },
        dataRule: {
          name: [
            { required: true, message: '学院名不能为空', trigger: 'blur' }
          ],
          introduction: [
            { required: true, message: '学院简介不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createdUser: [
            { required: true, message: '创建者用户ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          updatedUser: [
            { required: true, message: '更新者用户ID不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除（1是，0否）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.collegeId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.collegeId) {
            this.$http({
              url: this.$http.adornUrl(`/user/colleges/info/${this.dataForm.collegeId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.colleges.name
                this.dataForm.introduction = data.colleges.introduction
                this.dataForm.createTime = data.colleges.createTime
                this.dataForm.createdUser = data.colleges.createdUser
                this.dataForm.updateTime = data.colleges.updateTime
                this.dataForm.updatedUser = data.colleges.updatedUser
                this.dataForm.isDelete = data.colleges.isDelete
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/user/colleges/${!this.dataForm.collegeId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'collegeId': this.dataForm.collegeId || undefined,
                'name': this.dataForm.name,
                'introduction': this.dataForm.introduction,
                'createTime': this.dataForm.createTime,
                'createdUser': this.dataForm.createdUser,
                'updateTime': this.dataForm.updateTime,
                'updatedUser': this.dataForm.updatedUser,
                'isDelete': this.dataForm.isDelete
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
